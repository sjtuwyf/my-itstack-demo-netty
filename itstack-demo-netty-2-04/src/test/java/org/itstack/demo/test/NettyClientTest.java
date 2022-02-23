package org.itstack.demo.test;

import io.netty.channel.ChannelFuture;
import org.itstack.demo.netty.client.NettyClient;
import org.itstack.demo.netty.domain.FileTransferProtocol;
import org.itstack.demo.netty.util.MsgUtil;

import java.io.File;

/**
 * @author ssqswyf
 * @date 2022/2/23
 */
public class NettyClientTest {

    public static void main(String[] args) {
        // 启动客户端
        ChannelFuture channelFuture = new NettyClient().connect("127.0.0.1", 7397);

        // 文件信息{文件大于1024kb方便测试断点续传}
        File file = new File("D:\\2.txt");
        FileTransferProtocol fileTransferProtocol = MsgUtil.builedRequestTransferFile(file.getAbsolutePath(), file.getName(), file.length());

        // 发送信息；请求传输文件
        channelFuture.channel().writeAndFlush(fileTransferProtocol);
    }

}
