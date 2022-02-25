package org.itstack.demo.netty.service;

import org.itstack.demo.netty.domain.MsgAgreement;
import org.itstack.demo.netty.redis.Publisher;
import org.itstack.demo.netty.redis.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
@Service("extServerService")
public class ExtServerService {

    @Resource
    private Publisher publisher;

    @Resource
    private RedisUtil redisUtil;

    public void push(MsgAgreement msgAgreement) {
        publisher.publishMessage("itstack-demo-netty-push-msgAgreement", msgAgreement);
    }

    public RedisUtil getRedisUtil() {
        return redisUtil;
    }

}
