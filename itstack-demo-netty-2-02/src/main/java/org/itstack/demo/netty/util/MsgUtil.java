package org.itstack.demo.netty.util;

import org.itstack.demo.netty.domain.MsgBody;

/**
 * @author ssqswyf
 * @date 2022/2/23
 */
public class MsgUtil {

    /**
     * 构建protobuf消息体
     */
    public static MsgBody buildMsg(String channelId, String msgInfo) {
        MsgBody.Builder msg = MsgBody.newBuilder();
        msg.setChannelId(channelId);
        msg.setMsgInfo(msgInfo);
        return msg.build();
    }

}
