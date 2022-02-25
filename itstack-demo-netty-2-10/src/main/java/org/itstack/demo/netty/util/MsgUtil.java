package org.itstack.demo.netty.util;

import org.itstack.demo.netty.domain.MsgDemo01;
import org.itstack.demo.netty.domain.MsgDemo02;
import org.itstack.demo.netty.domain.MsgDemo03;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public class MsgUtil {

    public static MsgDemo01 buildMsgDemo01(String channelId, String msgContent) {
        return new MsgDemo01(channelId, msgContent);
    }

    public static MsgDemo02 buildMsgDemo02(String channelId, String msgContent) {
        return new MsgDemo02(channelId, msgContent);
    }

    public static MsgDemo03 buildMsgDemo03(String channelId, String msgContent) {
        return new MsgDemo03(channelId, msgContent);
    }

}
