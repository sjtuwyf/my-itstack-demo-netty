package org.itstack.demo.netty.util;

import org.itstack.demo.netty.domain.MsgInfo;

/**
 * @author ssqswyf
 * @date 2022/2/23
 */
public class MsgUtil {

    public static MsgInfo buildMsg(String channelId,String msgContent) {
        return new MsgInfo(channelId,msgContent);
    }

}
