package com.example.recommendationservice.service;

import com.example.recommendationservice.entity.ApDomain;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface ApDomainService {

    List<ApDomain> getByParentCode(String parentCode, String token) throws ValidationException;

    ApDomain getByCodeAndPermission(String code, String token);

    ApDomain update(ApDomain apDomain, String token);

    ApDomain getByCode(String code);



}
