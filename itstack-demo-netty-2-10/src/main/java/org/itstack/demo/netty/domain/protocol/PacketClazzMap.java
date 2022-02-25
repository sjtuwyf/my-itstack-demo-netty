package org.itstack.demo.netty.domain.protocol;


import org.itstack.demo.netty.domain.MsgDemo01;
import org.itstack.demo.netty.domain.MsgDemo02;
import org.itstack.demo.netty.domain.MsgDemo03;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public class PacketClazzMap {

    public final static Map<Byte,Class<? extends Packet>> packetTypeMap = new ConcurrentHashMap<>();

    static {
        packetTypeMap.put(Command.Demo01, MsgDemo01.class);
        packetTypeMap.put(Command.Demo02, MsgDemo02.class);
        packetTypeMap.put(Command.Demo03, MsgDemo03.class);
    }

}
