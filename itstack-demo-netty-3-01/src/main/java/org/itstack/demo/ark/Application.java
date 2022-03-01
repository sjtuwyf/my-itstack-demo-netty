package org.itstack.demo.ark;

import io.netty.channel.Channel;
import org.itstack.demo.ark.domain.ServerInfo;
import org.itstack.demo.ark.server.socket.NettyServer;
import org.itstack.demo.ark.server.websocket.WsNettyServer;
import org.itstack.demo.ark.util.CacheUtil;
import org.itstack.demo.ark.util.NetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ssqswyf
 * @date 2022/3/1
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(Application.class);

    @Value("${netty.socket.port}")
    private int nettyServerPort;

    @Value("${netty.websocket.port}")
    private int nettyWsServerPort;

    // 默认线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 启动NettyServer-socket
        logger.info("启动NettyServer服务，启动端口：{}", nettyServerPort);
        NettyServer nettyServer = new NettyServer(new InetSocketAddress(nettyServerPort));
        Future<Channel> future = executorService.submit(nettyServer);
        Channel channel = future.get();
        if (null == channel) {
            throw new RuntimeException("netty server-s open error channel is null");
        }

        while (!channel.isActive()) {
            logger.info("启动NettyServer服务，循环等待启动...");
            Thread.sleep(500);
        }
        logger.info("启动NettyServer服务，完成：{}", channel.localAddress());
        CacheUtil.serverInfoMap.put(nettyServerPort, new ServerInfo("NettySocket", NetUtil.getHost(), nettyServerPort, new Date()));

        // 启动NettyServer-websocket
        logger.info("启动NettyWsServer服务，启动端口：{}", nettyWsServerPort);
        WsNettyServer wsNettyServer = new WsNettyServer(new InetSocketAddress(nettyWsServerPort));
        Future<Channel> wsFuture = executorService.submit(wsNettyServer);
        Channel wsChannel = wsFuture.get();
        if (null == wsChannel) {
            throw new RuntimeException("netty server-ws open error channel is null");
        }
        if (!wsChannel.isActive()) {
            logger.info("启动NettyWsServer服务，循环等待启动...");
            Thread.sleep(500);
        }
        logger.info("启动NettyWsServer服务，完成：{}", wsChannel.localAddress());
        CacheUtil.serverInfoMap.put(nettyServerPort, new ServerInfo("NettyWsSocket", NetUtil.getHost(), nettyServerPort, new Date()));
    }
}
