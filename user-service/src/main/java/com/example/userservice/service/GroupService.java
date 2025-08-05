package com.example.userservice.service;

import com.example.userservice.dto.request.GroupRequest;

public interface GroupService {

    Object createGroup(GroupRequest request, String username);

    Object updateGroup(GroupRequest request);

    Object getGroups(GroupRequest request);

    Object deleteGroup(Long id);

    Object getGroup(Long id);

}
