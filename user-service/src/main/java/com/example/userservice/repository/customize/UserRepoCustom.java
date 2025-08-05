package com.example.userservice.repository.customize;

import com.example.userservice.dto.request.UserRequest;
import com.example.core.dto.response.ListDataResponse;

public interface UserRepoCustom {

    ListDataResponse<Object> findAccountByCondition(UserRequest request);

}
