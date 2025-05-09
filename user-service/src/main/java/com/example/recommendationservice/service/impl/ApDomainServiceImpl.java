package com.example.recommendationservice.service.impl;

import com.example.exception.ValidationException;
import com.example.service.impl.MyDictionaryServiceImpl;
import com.example.recommendationservice.entity.ApDomain;
import com.example.recommendationservice.repository.ApDomainRepository;
import com.example.recommendationservice.security.JwtProvider;
import com.example.recommendationservice.service.ApDomainService;
import com.example.recommendationservice.utils.Constant;
import com.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
    public ApDomain update(ApDomain apDomain, String token) {
        validate(apDomain);
        apDomain.setUpdatedBy("username");
        apDomain.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return domainRepository.save(apDomain);
    }

    @Override
    public ApDomain getByCode(String code) {
        return null;
    }

    @Override
    public ApDomain createApDomain(ApDomain apDomain) {
        return null;
    }

    private void validate(ApDomain apDomain) {

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
