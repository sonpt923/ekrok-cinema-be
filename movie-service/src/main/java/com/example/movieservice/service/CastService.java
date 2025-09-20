package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.entity.Cast;
import com.example.movieservice.entity.Movie;

import java.util.List;

public interface CastService {

    Cast createCast(CastRequest request, String username);

    Cast updateCast(CastRequest request, String username);

    ListDataResponse<Cast> getCasts(CastRequest request);

    Cast getCast(Long id);

    Boolean deleteCast(Long id, String username);

}
