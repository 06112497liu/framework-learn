package com.lwb.controller.mq;

import com.lwb.constant.TopicList;
import com.lwb.result.RestResult;
import com.lwb.constant.QueueList;
import com.lwb.service.mq.producer.QueueProducer;
import com.lwb.service.mq.producer.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweibo
 * @date 2018/5/4
 */
@RestController
@RequestMapping("/mq/produce")
public class ProduceMsgController {

    @Autowired
    private QueueProducer queueProducer;

    @Autowired
    private TopicProducer topicProducer;

    @GetMapping("/queue/{msg}")
    public RestResult produce(@PathVariable("msg") String msg) {
        queueProducer.sendMsg(QueueList.BUSINESS1, msg);
        return RestResult.ok();
    }

    @GetMapping("/topic/{msg}")
    public RestResult produce2(@PathVariable("msg") String msg) {
        topicProducer.sendMsg(TopicList.TOPIC1, msg);
        return RestResult.ok();
    }
}
