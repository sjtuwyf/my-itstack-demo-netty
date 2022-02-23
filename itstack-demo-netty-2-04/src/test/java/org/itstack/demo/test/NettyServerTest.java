package org.itstack.demo.test;


import org.itstack.demo.netty.server.NettyServer;

/**
 * @author ssqswyf
 * @date 2022/2/23
 */
public class NettyServerTest {

    public static void main(String[] args) {
        // 启动服务
        new NettyServer().bing(7397);
    }

}
