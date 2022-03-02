package com.example.springbootredis.controller;

import com.example.springbootredis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web-redis")
public class MyContorller {

    @Autowired
    private IRedisService redisService;

    @GetMapping("/put")
    public void put() {
        redisService.put("put01", "redis01", 1);
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        return redisService.get(key);
    }

    @GetMapping("/expire/{key}")
    public Boolean expire(@PathVariable String key) {
        return redisService.expire(key, 1);
    }

    @GetMapping("/delete/{key}")
    public void delete(@PathVariable String key) {
        redisService.delete(key);
    }

}
