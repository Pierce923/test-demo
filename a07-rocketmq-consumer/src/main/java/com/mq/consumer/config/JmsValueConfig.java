package com.mq.consumer.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JmsValueConfig {

    @Value("${rocketmq.namesrvAddr}")
    private String nameServerIp;

    /**
     * 消费组,消费者必须在消费组内
     */
    @Value("${rocketmq.consumer.groupName}")
    private String consumerGroup;

    /**
     * 生产组,生产者必须在生产组内
     */
    @Value("${rocketmq.producer.groupName}")
    private String producerGroup;


}
