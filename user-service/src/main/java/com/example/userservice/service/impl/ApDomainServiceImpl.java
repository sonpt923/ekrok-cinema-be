package com.example.userservice.service.impl;

import com.example.userservice.entity.ApDomain;
import com.example.userservice.service.ApDomainService;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;

@Service
public class ApDomainServiceImpl implements ApDomainService {

    @Override
    public List<ApDomain> getByParentCode(String parentCode, String token) throws ValidationException {
        return null;
    }

    @Override
    public ApDomain getByCodeAndPermission(String code, String token) {
        return null;
    }

    @Override
    public ApDomain update(ApDomain apDomain, String token) {
        return null;
    }

    @Override
    public ApDomain getByCode(String code) {
        return null;
    }
}
