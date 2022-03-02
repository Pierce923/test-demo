package com.mq.producer.config;

public class JmsConfig {

    /**
     * 端口
     */
    public static final String NAME_SERVER = "47.115.45.141:10910";

    /**
     * topic,消息依赖于topic
     */
    public static final String TOPIC = "test-pierce-topic";

    /**
     * 消费组,消费者必须在消费组内
     */
    public static final String CONSUMER_GROUP = "pierce_consumer_group";

    /**
     * 生产组,生产者必须在生产组内
     */
    public static final String PRODUCER_GROUP = "pierce_producer_group";

}
