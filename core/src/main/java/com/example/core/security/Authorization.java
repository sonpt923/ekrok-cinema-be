package com.example.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class Authorization {

    @Autowired
    private RedisTemplate redisTemplate;

    public void checkPermission(String listGroup) {


    }


}
