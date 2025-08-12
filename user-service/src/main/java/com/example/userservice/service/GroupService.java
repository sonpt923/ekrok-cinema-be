package com.example.userservice.service;

import com.example.userservice.dto.request.GroupRequest;

public interface GroupService {

    Object createGroup(GroupRequest request, String username);

    Object updateGroup(GroupRequest request, String username);

    Object getGroups(GroupRequest request, String username);

    Object deleteGroup(Long id, String username);

    Object getGroup(Long id, String username);

    Object getGroupByUsername(String username);

}
