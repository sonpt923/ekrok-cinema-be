package com.example.userservice.service;

import com.example.userservice.dto.request.ApDomainRequest;
import com.example.userservice.entity.ApDomain;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface ApDomainService {

    List<ApDomain> getApDomainByCondition(ApDomainRequest request);

    ApDomain getByCodeAndPermission(String code, String token);

    ApDomain update(ApDomainRequest request);

    ApDomain getByCode(String code);

    ApDomain createApDomain(ApDomainRequest request);



}
