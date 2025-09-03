package com.example.movieservice.service.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.entity.Cast;
import com.example.movieservice.repository.CastRepository;
import com.example.movieservice.service.CloudFlareService;
import com.example.movieservice.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CastServiceImpl implements CastService {

    @Autowired
    private CloudFlareService cloudFlareService;

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private


    @Override
    public Cast createCast(CastRequest request) {
        validateCreateCast(request);
        return null;
    }

    @Override
    public Cast updateCast(CastRequest request) {
        validateUpdateCast(request);
        return null;
    }

    @Override
    public ListDataResponse<Cast> getCasts(CastRequest request) {
        return null;
    }

    @Override
    public Cast getCast(Long id) {
        return null;
    }

    @Override
    public Boolean deleteCast(Long id) {
        return null;
    }

    private void validateCreateCast(CastRequest castRequest){

    }

    private void validateUpdateCast(CastRequest castRequest){

    }

}
