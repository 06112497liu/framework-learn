package com.lwb.controller.mq;

import com.lwb.common.result.RestResult;
import com.lwb.enums.TopicEnum;
import com.lwb.service.mq.producer.TestProducer;
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
    private TestProducer testProducer;

    @GetMapping("/{msg}")
    public RestResult produce(@PathVariable("msg") String msg) {
        testProducer.sendMsg(TopicEnum.TEST_TOPIC.getName(), msg);
        return RestResult.ok();
    }
}
