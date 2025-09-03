package com.example.movieservice.repository.customize.impl;

import com.example.core.dto.response.ListDataResponse;
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



        return null;
    }
}
