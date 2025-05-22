package com.example.userservice.repository.customize;

import com.example.dto.base.ListDataResponse;
import com.example.userservice.dto.request.UserRequest;
import com.example.userservice.dto.response.UserResponse;

public interface UserRepositoryCustom {

    ListDataResponse<Object> findAccountByCondition(UserRequest request);

}
