package com.example.paymentservice.service.impl;

import com.example.paymentservice.entity.Chair;
import com.example.paymentservice.repository.ChairRepository;
import com.example.paymentservice.service.ChairService;
import com.example.paymentservice.service.ChairTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairServiceImpl implements ChairService {

    @Autowired
    private ChairRepository chairRepository;

    @Autowired
    private ChairTypeService chairTypeService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void createBatchChair(List<Chair> listChair) {

    }

    @Override
    public void udpateChair(Chair chair) {

    }

    @Override
    public Chair getDetailChair(Chair chair) {
        return null;
    }
}
