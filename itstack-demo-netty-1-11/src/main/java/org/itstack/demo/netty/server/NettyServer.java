package org.itstack.demo.netty.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @author ssqswyf
 * @date 2022/2/22
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)     //广播
                    .option(ChannelOption.SO_RCVBUF, 2048 * 1024) // 设置UDP读缓冲区为2M
                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024) // 设置UDP写缓冲区为1M
                    .handler(new MyChannelInitializer());

            ChannelFuture f = b.bind(8080).sync();
            System.out.println("itstack-demo-netty udp server start done. {关注公众号：bugstack虫洞栈，获取源码}");

            f.channel().closeFuture().sync();

        } finally {
            // 优雅的关闭释放内存
            group.shutdownGracefully();
        }
    }

}