package com.example.userservice.repository.customize;

import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.dto.respond.ListDataResponse;

public interface UserRepositoryCustom {

    ListDataResponse<Object> findAccountByCondition(UserRequest request);

}
