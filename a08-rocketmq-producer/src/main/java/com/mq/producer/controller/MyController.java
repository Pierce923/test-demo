package com.mq.producer.controller;

import com.mq.producer.config.JmsConfig;
import com.mq.producer.service.MyProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/mq-producer")
@Slf4j
public class MyController {

    @Autowired
    private MyProducer producer;

    @GetMapping("/put/{text}")
    public Object putmq(@PathVariable String text) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        // 创建消息  主题   二级分类   消息内容好的字节数组
        Message message = new Message(JmsConfig.TOPIC, "taga", ("hello rocketMQ " + text).getBytes());

        SendResult send = producer.getProducer().send(message);

        log.info(send.toString());

        return new HashMap<>();
    }

}
