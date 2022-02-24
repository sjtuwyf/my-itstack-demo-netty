package org.itstack.demo.netty.util;

import com.alibaba.fastjson.JSON;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.itstack.demo.netty.domain.ServerMsgProtocol;



/**
 * @author ssqswyf
 * @date 2022/2/24
 */
public class MsgUtil {

    public static TextWebSocketFrame buildMsgAll(String channelId,String magInfo) {
        // 模拟头像
        int i = Math.abs(channelId.hashCode()) % 10;

        ServerMsgProtocol msg = new ServerMsgProtocol();
        // 链接信息;1自发信息、2群发消息
        msg.setType(2);
        msg.setChannelId(channelId);
        msg.setUserHeadImg("head" + i + ".jpg");
        msg.setMsgInfo(magInfo);

        return new TextWebSocketFrame(JSON.toJSONString(msg));
    }

    public static  TextWebSocketFrame buildMsgOwner(String channelId) {
        ServerMsgProtocol msg = new ServerMsgProtocol();
        //链接信息;1链接信息、2消息信息
        msg.setType(1);
        msg.setChannelId(channelId);
        return new TextWebSocketFrame(JSON.toJSONString(msg));

    }

}
