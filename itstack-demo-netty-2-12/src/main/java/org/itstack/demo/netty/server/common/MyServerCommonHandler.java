package org.itstack.demo.netty.server.common;

import io.netty.channel.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public abstract class MyServerCommonHandler extends SimpleChannelInboundHandler<String> {

    protected boolean sendFlag;
    private Runnable counterTask;
    private AtomicLong consumeMsgLength = new AtomicLong();
    private long priorProgress;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        counterTask = () -> {
            while (true) {
                try {
                    Thread.sleep(500);
                    long length = consumeMsgLength.getAndSet(0);
                    if (0 == length) {
                        continue;
                    }
                    System.out.println("数据发送速率(KB/S)：" + length);
                } catch (InterruptedException e) {

                }
            }
        };
        super.handlerAdded(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        sendData(ctx);
        // 启动监控线程
        new Thread(counterTask).start();
    }

    protected abstract void sendData(ChannelHandlerContext ctx);

    protected ChannelProgressivePromise getChannelProgressivePromise(ChannelHandlerContext ctx, Consumer<ChannelProgressiveFuture> completedAction) {
        ChannelProgressivePromise channelProgressivePromise = ctx.newProgressivePromise();
        channelProgressivePromise.addListener(new ChannelProgressiveFutureListener() {
            @Override
            public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) throws Exception {
                consumeMsgLength.addAndGet(progress - priorProgress);
                priorProgress = progress;
            }

            @Override
            public void operationComplete(ChannelProgressiveFuture future) throws Exception {
                sendFlag = false;
                if (future.isSuccess()) {
                    System.out.println("微信公众号：bugstack虫洞栈 | 提醒，消息发送成功！");
                    priorProgress -= 10;
                    Optional.ofNullable(completedAction).ifPresent(action -> action.accept(future));
                } else {
                    System.out.println("微信公众号：bugstack虫洞栈 | 提醒，消息发送失败！");
                    future.cause().printStackTrace();
                }
            }
        });
        return channelProgressivePromise;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("微信公众号：bugstack虫洞栈 | NettyServer接收到消息：" + msg);
    }

}
