package com.lwb.service.mq.consumer;//package com.lwb.service.mq.consumer;
//
//import com.lwb.enums.TopicEnum;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//
///**
// * @author liuweibo
// * @date 2018/5/4
// */
//@Component
//public class TestConsumer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(TestConsumer.class);
//
//    @JmsListener(destination = "test_topic")
//    public void testTopicListener(String msg) {
//        LOGGER.info("监听到MQ：{}对列的消息：{}", TopicEnum.TEST_TOPIC.getName(), msg);
//        System.out.println("消费没有啊啊啊啊啊啊啊");
//    }
//
//}