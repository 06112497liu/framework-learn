package com.lwb.service.mq.producer.impl;

import com.lwb.enums.TopicEnum;
import com.lwb.service.mq.producer.TestProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author liuweibo
 * @date 2018/5/4
 */
@Service
public class TestProducerImpl implements TestProducer {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestProducerImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMsg(String destName, String msg) {
        LOGGER.info("推送消息：{} --> MQ的{}对列", msg, destName);
        ActiveMQQueue queue = new ActiveMQQueue(destName);
        jmsTemplate.convertAndSend(queue, msg);
    }

    @JmsListener(destination = "test_topic")
    public void testTopicListener(String msg) {
        LOGGER.info("监听到MQ：{}对列的消息：{}", TopicEnum.TEST_TOPIC.getName(), msg);
        System.out.println("消费没有啊啊啊啊啊啊啊");
    }

}
