package org.itstack.demo.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.itstack.demo.netty.domain.protocol.PacketClazzMap;
import org.itstack.demo.netty.util.SerializationUtil;

import java.util.List;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public class ObjDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }
        // 读取指令
        byte command = in.readByte();
        // 指令占了一位，剔除掉
        byte[] data = new byte[dataLength-1];
        in.readBytes(data);
        out.add(SerializationUtil.deserialize(data, PacketClazzMap.packetTypeMap.get(command)));
    }
}
