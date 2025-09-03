package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Cast;
import com.example.movieservice.entity.Genre;

public interface GenreService {

    Genre createCast(GenreRequest request);

    Genre updateCast(GenreRequest request);

    ListDataResponse<Cast> getCasts(GenreRequest request);

    Genre getCast(Long id);

    Boolean deleteCast(Long id);

}
