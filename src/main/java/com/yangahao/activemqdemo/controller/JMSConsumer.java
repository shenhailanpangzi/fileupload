package com.yangahao.activemqdemo.controller;

import com.yangahao.activemqdemo.configs.JmsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description：
 * @Author:yanghao
 * @Date：2018/7/9 14:18
 */
@Component
public class JMSConsumer {
    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

//    @JmsListener(destination = "springboot.queue.test")
//    public void receiveQueue(String msg) {
//        logger.info("接收到消息：{}",msg);
//    }
    @JmsListener(destination = JmsConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage(String msg) {
        logger.info("接收到topic消息：{}",msg);
    }

    @JmsListener(destination = JmsConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage(String msg) {
        logger.info("接收到queue消息：{}",msg);
    }
}
