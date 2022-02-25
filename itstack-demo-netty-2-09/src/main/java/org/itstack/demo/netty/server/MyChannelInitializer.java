package org.itstack.demo.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.itstack.demo.netty.service.ExtServerService;

import java.nio.charset.Charset;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {

    private ExtServerService extServerService;

    public MyChannelInitializer(ExtServerService extServerService) {
        this.extServerService = extServerService;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 基于换行符号
        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        // string转编码，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyServerHandler(extServerService));

    }
}
