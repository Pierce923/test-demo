package com.example.springbootredis.service.impl;

import com.example.springbootredis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService implements IRedisService {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> vOps;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void put(String key, String value, Integer expHours) {
        vOps.set(key, value, expHours);
    }

    @Override
    public String get(String key) {
        return vOps.get(key);
    }

    @Override
    public Boolean expire(String key, Integer expHours) {
        return redisTemplate.expire(key, expHours, TimeUnit.HOURS);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }


}
