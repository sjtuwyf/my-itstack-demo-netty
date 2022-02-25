package org.itstack.demo.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressiveFuture;
import org.itstack.demo.netty.server.common.MyServerCommonHandler;

import java.util.function.Consumer;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public class MyServerHandler extends MyServerCommonHandler {
    @Override
    protected void sendData(ChannelHandlerContext ctx) {
        sendFlag = true;
        ctx.writeAndFlush("111111111122222222223333333333\r\n", getChannelProgressivePromise(ctx, new Consumer<ChannelProgressiveFuture>() {
            @Override
            public void accept(ChannelProgressiveFuture channelProgressiveFuture) {
                if (ctx.channel().isWritable() && !sendFlag) {
                    sendData(ctx);
                }
            }
        }));
    }
}
