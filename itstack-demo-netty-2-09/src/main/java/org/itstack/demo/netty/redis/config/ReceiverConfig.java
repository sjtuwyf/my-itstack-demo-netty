package org.itstack.demo.netty.redis.config;

import org.itstack.demo.netty.domain.MsgAgreement;
import org.itstack.demo.netty.redis.MsgAgreementReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author ssqswyf
 * @date 2022/2/25
 */
@Configuration
public class ReceiverConfig {

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter msgAgreementListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(msgAgreementListenerAdapter,new PatternTopic("itstack-demo-netty-push-msgAgreement"));
        return container;
    }

    @Bean
    public MessageListenerAdapter msgAgreementListenerAdapter(MsgAgreementReceiver receiver) {
        return new MessageListenerAdapter(receiver,"receiveMessage");
    }
}
