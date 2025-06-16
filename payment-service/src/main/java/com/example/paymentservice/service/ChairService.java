package com.example.paymentservice.service;

import com.example.paymentservice.entity.Chair;

import java.util.List;

public interface ChairService {

    void createBatchChair(List<Chair> listChair);

    void udpateChair(Chair chair);

    Chair getDetailChair(Chair chair);

}
