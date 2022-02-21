package org.itstack.demo.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author ssqswyf
 * @date 2022/2/21
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.out.println("链接报告开始");
        System.out.println("链接报告信息，有一客户端链接到本服务器");
        System.out.println("链接报告IP:"+socketChannel.localAddress().getHostString());
        System.out.println("链接报告Port"+socketChannel.localAddress().getPort());
        System.out.println("链接报告完毕");
    }
}
