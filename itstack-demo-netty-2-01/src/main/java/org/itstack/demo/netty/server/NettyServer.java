package org.itstack.demo.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author ssqswyf
 * @date 2022/2/22
 */
@Component("nettyServer")
public class NettyServer {

    private Logger logger = LoggerFactory.getLogger(NettyServer.class);

    //配置服务端NIO线程组
    private final EventLoopGroup parentGroup = new NioEventLoopGroup();
    private final EventLoopGroup childGroup = new NioEventLoopGroup();

    private Channel channel;





}
