package org.itstack.demo.netty.util;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.netty.domain.MsgAgreement;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
public class MsgUtil {

    public static MsgAgreement buildMsg(String channelId, String content) {
        return new MsgAgreement(channelId, content);
    }

    public static MsgAgreement json2Obj(String objJsonStr) {
        return JSON.parseObject(objJsonStr, MsgAgreement.class);
    }

    public static String obj2Json(MsgAgreement msgAgreement) {
        return JSON.toJSONString(msgAgreement) + "\r\n";
    }
}
