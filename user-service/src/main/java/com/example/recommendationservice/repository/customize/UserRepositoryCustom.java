package com.example.recommendationservice.repository.customize;

import com.example.dto.base.ListDataResponse;
import com.example.recommendationservice.dto.request.UserRequest;

public interface UserRepositoryCustom {

    ListDataResponse<Object> findAccountByCondition(UserRequest request);

}
