package com.lwb.service.mq.producer.impl;

import com.lwb.service.mq.producer.TopicProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicProducerImpl implements TopicProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicProducerImpl.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMsg(String destName, String msg) {
        this.LOGGER.info("推送消息：{} --> MQ的Topic：{}", msg, destName);
        ActiveMQTopic topic = new ActiveMQTopic(destName);
        this.jmsMessagingTemplate.convertAndSend(topic, msg);
    }
}
