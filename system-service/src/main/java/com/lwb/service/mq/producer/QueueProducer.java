package com.lwb.service.mq.producer;

import javax.jms.JMSException;

/**
 * @author liuweibo
 * @date 2018/5/4
 */
public interface QueueProducer {

    /**
     * 发送textMessage消息
     * @param destName
     * @param msg
     */
    void sendTxtMsg(String destName, String msg);

    /**
     * 发送ObjectMessage消息
     * @param destName
     * @param msg
     */
    void sendObjMsg(String destName, String msg) throws JMSException;

    /**
     * 发送MapMessage消息
     * @param destName
     * @param msg
     */
    void sendMapMsg(String destName, String msg);

}
