package com.example.paymentservice.repository.customize;

import com.example.paymentservice.dto.request.ProvinceRequest;
import com.example.dto.base.ListDataResponse;

public interface ProvinceRepositoryCustom {

    ListDataResponse findProviceByCondition(ProvinceRequest request);

}
