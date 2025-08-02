package com.example.userservice.service.impl;

import com.example.core.exception.ValidateException;
import com.example.core.i18n.Dictionary;
import com.example.core.utils.BaseConstant;
import com.example.core.utils.ObjectUtil;
import com.example.userservice.dto.request.GroupRequest;
import com.example.userservice.entity.Group;
import com.example.userservice.fiegn.NotificationFeign;
import com.example.userservice.repository.GroupRepository;
import com.example.userservice.service.GroupService;
import feign.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private Dictionary dic;


    @Autowired
    private NotificationFeign notificationFeign;

    @Override
    public Object createGroup(GroupRequest request) {
        validateCreate(request);
        Group group = Group.builder()
                .code(request.getCode())
                .name(request.getName())
                .description(request.getDescription())
                .createdAt(new Timestamp())
                .isDeleted(false)
                .parentCode(request.getParentCode())
                .
                .build();
        return null;
    }

    @Override
    public Object updateGroup(GroupRequest request) {
        return null;
    }

    @Override
    public Object getGroups(GroupRequest request) {
        return null;
    }

    @Override
    public Object deleteGroup(Long id) {
        return null;
    }

    @Override
    public Object getGroup(Long id) {
        return null;
    }

    private void validateCreate(GroupRequest request){

        if(ObjectUtil.objectIsNullorEmpty(request.getCode())){
            throw new ValidateException("", "");
        }

        if(ObjectUtil.objectIsNullorEmpty(request.getName())){
            throw new ValidateException("", "");
        }

        Group group = groupRepository.findByCodeAndStatus(request.getCode(), false);
        if(group != null){
            throw new ValidateException(BaseConstant.ERORRS.DATA_USING, dic.get(""));
        }

        if(ObjectUtil.objectIsNullorEmpty(request.getCode())){

        }

    }

    private void validateUpdate(GroupRequest request){

    }

}
