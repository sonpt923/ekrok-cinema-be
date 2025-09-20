package com.example.movieservice.service.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.core.exception.ValidateException;
import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.entity.Cast;
import com.example.movieservice.entity.Movie;
import com.example.movieservice.repository.CastRepository;
import com.example.movieservice.repository.customize.CastRepoCustom;
import com.example.movieservice.service.CastService;
import com.example.movieservice.service.CloudFlareService;
import com.example.movieservice.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CastServiceImpl implements CastService {

    @Autowired
    private CastRepository castRepository;

    @Autowired
    private CastRepoCustom castRepoCustom;


    @Override
    public Cast createCast(CastRequest request, String username) {
        validateCreateCast(request);
        String pathImage = "";
        Cast cast = Cast.builder()
                .code(Constant.START_CODE.CAST + UUID.randomUUID()).image(pathImage).name(request.getName())
                .gender(request.getGender()).biography(request.getBiography())
                .birthDate(request.getBirthDate()).isDeleted(false).build();
        return castRepository.save(cast);
    }

    @Override
    public Cast updateCast(CastRequest request, String username) {
        validateUpdateCast(request);
        return null;
    }

    @Override
    public ListDataResponse<Cast> getCasts(CastRequest request) {
        validateGetData(request);
        return castRepoCustom.getCasts(request);
    }

    @Override
    public Cast getCast(Long id) {
        return castRepository.findById(id).orElseThrow(
                () -> {
                    throw new ValidateException("", "");
                }
        );
    }

    @Override
    public Boolean deleteCast(Long id, String username) {
        return null;
    }

    private void validateCreateCast(CastRequest castRequest) {

    }

    private void validateUpdateCast(CastRequest castRequest) {

    }

    private void validateGetData(CastRequest request) {

    }

}
