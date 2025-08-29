package com.example.subcriptionservice.repository.customize.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.core.utils.ObjectUtil;
import com.example.subcriptionservice.dto.request.PlanRequest;
import com.example.subcriptionservice.repository.customize.PlanRepoCustomize;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PlanRepoCustomizeImpl implements PlanRepoCustomize {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public ListDataResponse<Object> getPlans(PlanRequest request) {
        StringBuilder str = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        ListDataResponse<Object> plans = new ListDataResponse<>();

        str.append(" SELECT p.* FROM plan p WHERE 1 = 1 ");

        if(ObjectUtil.objectIsNullorEmpty(request.getCode())){
            str.append(" AND p.code = :code ");
            params.put("code", request.getCode());
        }




        return plans;
    }
}
