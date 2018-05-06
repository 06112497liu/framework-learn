package com.lwb.service.mq.producer;

/**
 * @author liuweibo
 * @date 2018/5/4
 */
public interface QueueProducer {

    /**
     * 发送消息
     * @param destName
     * @param msg
     */
    void sendMsg(String destName, String msg);

}
