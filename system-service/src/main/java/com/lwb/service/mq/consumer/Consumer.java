package com.lwb.service.mq.consumer;

import com.lwb.constant.QueueList;
import com.lwb.constant.TopicList;
import org.apache.activemq.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;


/**
 * @author liuweibo
 * @date 2018/5/4
 */
@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private ConnectionFactory connectionFactory;

    /**
     * @param msg 这个msg的类型可以是很多中类型，甚至可以是单纯的string，是string的话，就是获取的消息的具体内容
     * @JmsListener 这个注解可重复，这样一个消费者可以消费多个queue或者多个topic的消息
     */
    @JmsListener(destination = QueueList.BUSINESS2)
    public void topicListener1(Message msg) throws JMSException {
        LOGGER.info("topicListener1 监听到MQ：{} 对列的消息：{}", QueueList.BUSINESS1, msg);
    }

    @JmsListener(destination = QueueList.BUSINESS2)
    public void topicListener11(Message msg) throws JMSException {
        LOGGER.info("topicListener11 监听到MQ：{} 对列的消息：{}", QueueList.BUSINESS1, msg);
    }

    @JmsListener(destination = QueueList.BUSINESS1)
    public void topicListener4(String msg) {
        LOGGER.info("topicListener4 监听到MQ：{} 对列的消息：{}", QueueList.BUSINESS1, msg);
    }

    @JmsListener(destination = TopicList.TOPIC2, containerFactory = "jmsListenerContainerTopic")
    public void topicListener2(String msg) {
        LOGGER.info("topicListener2 监听到MQ：{} topic的消息：{}", TopicList.TOPIC1, msg);
    }

    @JmsListener(destination = TopicList.TOPIC2, containerFactory = "jmsListenerContainerTopic")
    public void topicListener3(String msg) {
        LOGGER.info("topicListener3 监听到MQ：{} topic的消息：{}", TopicList.TOPIC1, msg);
    }
}
