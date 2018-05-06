package com.lwb.service.mq.consumer;

import com.lwb.constant.QueueList;
import com.lwb.constant.TopicList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;


/**
 * @author liuweibo
 * @date 2018/5/4
 */
@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = QueueList.BUSINESS1)
    public void topicListener1(String msg) {
        LOGGER.info("监听到MQ：{} 对列的消息：{}", QueueList.BUSINESS1, msg);
    }


    @JmsListener(destination = TopicList.TOPIC2, containerFactory = "jmsListenerContainerTopic")
    public void topicListener2(String msg) {
        LOGGER.info("监听到MQ：{} topic的消息：{}", TopicList.TOPIC1, msg);
    }

}
