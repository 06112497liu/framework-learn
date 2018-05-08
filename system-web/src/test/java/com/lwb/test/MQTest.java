package com.lwb.test;

import com.lwb.constant.QueueList;
import com.lwb.service.mq.producer.QueueProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MQTest {

    @Resource
    private QueueProducer testProducer;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            testProducer.sendTxtMsg(QueueList.BUSINESS1, "Queue Message " + i);
        }
    }
}
