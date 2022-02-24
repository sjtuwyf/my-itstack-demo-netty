package org.itstack.demo.netty.domain;

/**
 * @author ssqswyf
 * @date 2022/2/24
 * 消息传输协议
 */
public class ClientMsgProtocol {

    /**
     * 1 请求个人信息， 2 发送聊天信息
     */
    private int type;

    /**
     * 消息
     */
    private String msgInfo;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }
}
