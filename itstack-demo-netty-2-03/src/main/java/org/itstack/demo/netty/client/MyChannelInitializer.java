package org.itstack.demo.netty.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.itstack.demo.netty.codec.ObjDecoder;
import org.itstack.demo.netty.codec.ObjEncoder;
import org.itstack.demo.netty.domain.MsgInfo;

/**
 * @author ssqswyf
 * @date 2022/2/23
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        //对象传输处理
        channel.pipeline().addLast(new ObjDecoder(MsgInfo.class));
        channel.pipeline().addLast(new ObjEncoder(MsgInfo.class));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(new MyClientHandler());
    }
}
