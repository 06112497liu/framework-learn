package com.lwb.service.mq.producer.impl;

import com.lwb.service.mq.producer.QueueProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author liuweibo
 * @date 2018/5/4
 */
@Service
public class QueueProducerImpl implements QueueProducer {

    private final static Logger LOGGER = LoggerFactory.getLogger(QueueProducerImpl.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMsg(String destName, String msg) {
        this.LOGGER.info("推送消息：{} --> MQ的对列：{}", msg, destName);
        ActiveMQQueue queue = new ActiveMQQueue(destName);
        this.jmsMessagingTemplate.convertAndSend(queue, msg);
    }
}
