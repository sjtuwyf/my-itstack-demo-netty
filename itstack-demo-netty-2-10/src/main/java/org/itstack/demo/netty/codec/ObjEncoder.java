package org.itstack.demo.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.itstack.demo.netty.domain.protocol.Packet;
import org.itstack.demo.netty.util.SerializationUtil;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public class ObjEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet in, ByteBuf out) throws Exception {
        byte[] data = SerializationUtil.serialize(in);
        out.writeInt(data.length+1);
        // 添加指令
        out.writeByte(in.getCommand());
        out.writeBytes(data);

    }
}
