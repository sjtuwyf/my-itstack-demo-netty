package org.itstack.demo.netty.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;

import java.util.concurrent.TimeUnit;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public class MyChannelFutureListener implements ChannelFutureListener {
    @Override
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (channelFuture.isSuccess()) {
            System.out.println("itstack-demo-netty client start done. {关注公众号：bugstack虫洞栈，获取源码}");
            return;
        }
        Channel channel;
        final EventLoop loop = channelFuture.channel().eventLoop();
        loop.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    new NettyClient().connect("127.0.0.1", 7397);
                    System.out.println("itstack-demo-netty client start done. {关注公众号：bugstack虫洞栈，获取源码}");
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println("itstack-demo-netty client start error go reconnect ... {关注公众号：bugstack虫洞栈，获取源码}");
                }
            }
        }, 1L, TimeUnit.SECONDS);

    }
}
