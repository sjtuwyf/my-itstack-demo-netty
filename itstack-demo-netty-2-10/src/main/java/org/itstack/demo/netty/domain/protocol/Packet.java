package org.itstack.demo.netty.domain.protocol;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public abstract class Packet {


    /**
     * 获取协议指令
     * @return 返回指令集
     */
    public abstract Byte getCommand();

}
