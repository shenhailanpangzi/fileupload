package com.yangahao.activemqdemo.bootjmstest;

import com.yangahao.activemqdemo.controller.JMSProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Description：
 * @Author:yanghao
 * @Date：2018/7/9 14:20
 */
public class JmsTest extends BaseTest{
    @Autowired
    private JMSProducer jmsProducer;
    @Autowired
    private Topic topic;
    @Autowired
    private Queue queue;

    /**
     * 仅发送queue消息
     */
    @Test
    public void testJms() {
        Destination destination = new ActiveMQQueue("springboot.queue.test");

        for (int i=0;i<10;i++) {
            jmsProducer.sendMessage(destination,"hello,world!" + i);
        }
    }

    /**
     * 发送queue和topic
     */
    @Test
    public void testJms1() {
        for (int i=0;i<10;i++) {
            jmsProducer.sendMessage(queue,"queue,world!" + i);
            jmsProducer.sendMessage(topic, "topic,world!" + i);
        }
    }
}