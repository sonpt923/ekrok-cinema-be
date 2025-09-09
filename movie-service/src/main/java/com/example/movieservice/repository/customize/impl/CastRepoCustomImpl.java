package com.example.movieservice.repository.customize.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.core.utils.ObjectUtil;
import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.entity.Cast;
import com.example.movieservice.repository.customize.CastRepoCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CastRepoCustomImpl implements CastRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public ListDataResponse<Cast> getCasts(CastRequest request) {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        sql.append(" SELECT c.* FROM cast c WHERE 1 = 1 ");

        if (ObjectUtil.objectIsNullorEmpty(request.getCode())) {
            sql.append(" AND c.code like CONCAT(%,:code,%) ");
            params.put("code", request.getCode());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getName())) {
            sql.append(" AND c.name like CONCAT(%,:name,%)");
            params.put("name", request.getName());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getGender())) {
            sql.append(" AND c.gender = :gender ");
            params.put("gender", request.getGender());
        }

//        if (ObjectUtil.objectIsNullorEmpty(request.getBirthDate())) {
//            sql.append(" AND c.birth_date = ")
//        }

        return null;
    }
}
