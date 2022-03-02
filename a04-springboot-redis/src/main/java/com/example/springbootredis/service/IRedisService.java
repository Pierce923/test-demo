package com.example.springbootredis.service;

/**
 * redis服务
 */
public interface IRedisService {

    /**
     * 存储key-value数据
     *
     * @param key
     * @param value
     * @param expHours
     */
    void put(String key, String value, Integer expHours);

    /**
     * 根据key，获取value
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置到期时间
     *
     * @param key
     * @param expHours
     * @return
     */
    Boolean expire(String key, Integer expHours);

    /**
     * 根据key，删除数据
     *
     * @param key
     */
    void delete(String key);

}
