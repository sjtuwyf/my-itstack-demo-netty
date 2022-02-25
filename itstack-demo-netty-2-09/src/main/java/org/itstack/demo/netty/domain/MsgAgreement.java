package org.itstack.demo.netty.domain;

/**
 * @author ssqswyf
 * @date 2022/2/25
 * 消息协议
 */
public class MsgAgreement {

    /**
     * 发送给某人，某人channelId
     */
    private String toChannelId;

    /**
     * 消息内容
     */
    private String content;

    public MsgAgreement() {
    }

    public MsgAgreement(String toChannelId, String content) {
        this.toChannelId = toChannelId;
        this.content = content;
    }

    public String getToChannelId() {
        return toChannelId;
    }

    public void setToChannelId(String toChannelId) {
        this.toChannelId = toChannelId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
