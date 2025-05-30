package com.example.userservice.service.impl;

import com.example.exception.ValidationException;
import com.example.service.impl.MyDictionaryServiceImpl;
import com.example.userservice.dto.request.ApDomainRequest;
import com.example.userservice.entity.ApDomain;
import com.example.userservice.repository.ApDomainRepository;
import com.example.userservice.service.ApDomainService;
import com.example.userservice.utils.Constant;
import com.example.utils.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApDomainServiceImpl implements ApDomainService {


    @Autowired
    private MyDictionaryServiceImpl dictionaryService;

    @Autowired
    private ApDomainRepository domainRepository;


    @Override
    public List<ApDomain> getByParentCode(String parentCode, String token) {
        if (StringUtil.stringIsNullOrEmty(parentCode)) {
            throw new ValidationException("", "");
        }
        List<ApDomain> apDomains = domainRepository.getByParentCode(parentCode);
        return apDomains;
    }

    @Override
    public ApDomain getByCodeAndPermission(String code, String token) {
        return null;
    }

    @Override
    public ApDomain update(ApDomainRequest request) {
        validate(request);
        ApDomain ap = ApDomain.builder().build();
        return domainRepository.save(ap);
    }

    @Override
    public ApDomain getByCode(String code) {
        return domainRepository.getByCode(code);
    }

    @Override
    public ApDomain createApDomain(ApDomainRequest request) {
        validate(request);
        return null;
    }

    private void validate(ApDomainRequest apDomain) {

        if (StringUtil.stringIsNullOrEmty(apDomain.getCode())) {
            throw new ValidationException(Constant.ERROR_NOT_NULL,
                    String.format(dictionaryService.get("ERROR.CREATE_ACCOUNT_FAIL"), "code"));
        }

        if (!StringUtil.stringIsNullOrEmty(apDomain.getCode())) {
            if (domainRepository.getByCode(apDomain.getCode()) != null) {
                throw new ValidationException(Constant.ERROR_DATA_EXITS, "code");
            }
        }

        if (StringUtil.stringIsNullOrEmty(apDomain.getType())) {
            throw new ValidationException(Constant.ERROR_NOT_NULL,
                    String.format(dictionaryService.get("ERROR.CREATE_ACCOUNT_FAIL"), "type"));
        }

        if (StringUtil.stringIsNullOrEmty(apDomain.getName())) {
            throw new ValidationException(Constant.ERROR_NOT_NULL,
                    String.format(dictionaryService.get("ERROR.CREATE_ACCOUNT_FAIL"), "name"));
        }

        if (StringUtil.stringIsNullOrEmty(apDomain.getStatus())) {
            throw new ValidationException(Constant.ERROR_NOT_NULL,
                    String.format(dictionaryService.get("ERROR.CREATE_ACCOUNT_FAIL"), "status"));
        }

        if (StringUtil.stringIsNullOrEmty(apDomain.getValue())) {
            throw new ValidationException(Constant.ERROR_NOT_NULL,
                    String.format(dictionaryService.get("ERROR.CREATE_ACCOUNT_FAIL"), "value"));
        }

        if (StringUtil.stringIsNullOrEmty(apDomain.getDescription())) {
            throw new ValidationException(Constant.ERROR_NOT_NULL,
                    String.format(dictionaryService.get("ERROR.CREATE_ACCOUNT_FAIL"), "description"));
        }

    }

}
