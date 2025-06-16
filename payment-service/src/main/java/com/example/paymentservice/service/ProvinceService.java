package com.example.paymentservice.service;

import com.example.paymentservice.dto.request.ProvinceRequest;
import com.example.paymentservice.entity.Province;
import com.example.dto.base.ListDataResponse;

public interface ProvinceService {

    Object createProvice(Province province);

    Object updateProvice(Province province);

    ListDataResponse findProviceByCondition(ProvinceRequest request);

}
