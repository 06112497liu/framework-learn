package com.lwb.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.broker.region.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class ActiveMQConfig {

    //需要给topic定义独立的JmsListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(Boolean.TRUE);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

//    @Bean
//    public RedeliveryPolicy redeliveryPolicy(){
//        RedeliveryPolicy  redeliveryPolicy=   new RedeliveryPolicy();
//        //是否在每次尝试重新发送失败后,增长这个等待时间
//        redeliveryPolicy.setUseExponentialBackOff(true);
//        //重发次数,默认为6次   这里设置为10次
//        redeliveryPolicy.setMaximumRedeliveries(10);
//        //重发时间间隔,默认为1秒
//        redeliveryPolicy.setInitialRedeliveryDelay(1);
//        //第一次失败后重新发送之前等待500毫秒,第二次失败再等待500 * 2毫秒,这里的2就是value
//        redeliveryPolicy.setBackOffMultiplier(2);
//        //是否避免消息碰撞
//        redeliveryPolicy.setUseCollisionAvoidance(false);
//        //设置重发最大拖延时间-1 表示没有拖延只有UseExponentialBackOff(true)为true时生效
//        redeliveryPolicy.setMaximumRedeliveryDelay(-1);
//        return redeliveryPolicy;
//    }
//
//
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory (@Value("${spring.activemq.broker-url}") String url,
//                                                                @Value("spring.activemq.user") String username,
//                                                                @Value("spring.activemq.password") String password,
//                                                                RedeliveryPolicy redeliveryPolicy){
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(username, password, url);
//        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
//        return activeMQConnectionFactory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory){
//
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setDeliveryMode(2);//进行持久化配置 1表示非持久化，2表示持久化
//        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
////        jmsTemplate.setDefaultDestination(queue); //此处可不设置默认，在发送消息时也可设置队列
//        jmsTemplate.setSessionAcknowledgeMode(4);//客户端签收模式</span>
//        return jmsTemplate;
//    }

}
