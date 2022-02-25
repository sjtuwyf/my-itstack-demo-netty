package org.itstack.demo.netty.redis;

import org.itstack.demo.netty.domain.MsgAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
@Service
public class Publisher {

    private final RedisTemplate<String, Object> redisMessageTemplate;

    @Autowired
    public Publisher(RedisTemplate<String, Object> redisMessageTemplate) {
        this.redisMessageTemplate = redisMessageTemplate;
    }

    public void publishMessage(String topic, MsgAgreement message) {
        redisMessageTemplate.convertAndSend(topic, message);
    }
}
