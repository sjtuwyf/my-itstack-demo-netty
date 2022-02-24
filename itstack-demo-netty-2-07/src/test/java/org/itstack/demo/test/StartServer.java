package org.itstack.demo.test;

import org.itstack.demo.netty.server.ServerSocket;

/**
 * @author ssqswyf
 * @date 2022/2/24
 */
public class StartServer {

    public static void main(String[] args) {
        new Thread(new ServerSocket()).start();
        System.out.println("itstack-demo-netty server start done. {关注公众号：bugstack虫洞栈，获取源码}");
    }

}
