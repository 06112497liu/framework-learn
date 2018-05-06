package com.lwb.service.mq.producer;

public interface TopicProducer {

    /**
     * 发送消息
     * @param destName
     * @param msg
     */
    void sendMsg(String destName, String msg);

}
