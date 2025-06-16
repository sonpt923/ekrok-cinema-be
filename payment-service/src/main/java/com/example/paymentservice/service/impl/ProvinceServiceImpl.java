package com.example.paymentservice.service.impl;

import com.example.paymentservice.dto.request.ProvinceRequest;
import com.example.paymentservice.entity.Province;
import com.example.paymentservice.repository.ProvinceRepository;
import com.example.paymentservice.repository.customize.ProvinceRepositoryCustom;
import com.example.paymentservice.service.ProvinceService;
import com.example.dto.base.ListDataResponse;
import com.example.exception.ValidationException;
import com.example.service.MydictionaryService;
import com.example.utils.BaseConstants;
import com.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private MydictionaryService dictionary;

    @Autowired
    private ProvinceRepositoryCustom provinceRepositoryCustom;

    @Override
    public Object createProvice(Province province) {
        validateProvice(province);
        return provinceRepository.save(province);
    }

    @Override
    public Object updateProvice(Province province) {
        validateProvice(province);
        return null;
    }

    @Override
    public ListDataResponse findProviceByCondition(ProvinceRequest request) {
        return provinceRepositoryCustom.findProviceByCondition(request);
    }

    private void validateProvice(Province province) {

        if (StringUtil.stringIsNullOrEmty(province.getCode())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL,
                    String.format(dictionary.get("ERROR.FIELD_IS_REQUIRED", "code")));
        }

        if (StringUtil.stringIsNullOrEmty(province.getName())) {
            throw new ValidationException(BaseConstants.ERROR_NOT_NULL,
                    String.format(dictionary.get("ERROR.FIELD_IS_REQUIRED", "name")));
        }
    }
}
