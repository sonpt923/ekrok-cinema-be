package com.example.userservice.repository.customize;

import com.example.core.dto.response.ListDataResponse;
import com.example.userservice.dto.request.GroupRequest;
import com.example.userservice.dto.request.UserRequest;

public interface GroupRepoCustom {

    ListDataResponse<Object> findGroups(GroupRequest request);

}
