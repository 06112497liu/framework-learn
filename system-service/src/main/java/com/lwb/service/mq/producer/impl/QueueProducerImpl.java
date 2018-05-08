package com.lwb.service.mq.producer.impl;

import com.lwb.bean.po.Person;
import com.lwb.service.mq.producer.QueueProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * @author liuweibo
 * @date 2018/5/4
 */
@Service
public class QueueProducerImpl implements QueueProducer {

    private final static Logger LOGGER = LoggerFactory.getLogger(QueueProducerImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送textMessage消息
     * @param destName
     * @param msg
     */
    @Override
    public void sendTxtMsg(String destName, String msg) {
        this.LOGGER.info("推送消息：{} --> MQ的对列：{}", msg, destName);
        ActiveMQQueue queue = new ActiveMQQueue(destName);
        this.jmsTemplate.convertAndSend(queue, msg);
    }

    @Override
    public void sendObjMsg(String destName, String msg) {
        ActiveMQQueue queue = new ActiveMQQueue(destName);
        MessageCreator creator = session -> {
            ObjectMessage m = session.createObjectMessage();
            Person person = new Person();
            person.setName("张三");
            m.setObject(person);
            return m;
        };
        this.jmsTemplate.send(queue, creator);
    }

    @Override
    public void sendMapMsg(String destName, String msg) {
        ActiveMQQueue queue = new ActiveMQQueue(destName);
        MessageCreator creator = session -> {
            MapMessage m = session.createMapMessage();
            m.setString(msg, "key");
            return m;
        };
        this.jmsTemplate.send(queue, creator);
    }
}
