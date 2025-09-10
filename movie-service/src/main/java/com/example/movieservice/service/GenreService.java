package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Cast;
import com.example.movieservice.entity.Genre;

public interface GenreService {

    Genre createGenre(GenreRequest request);

    Genre updateGenre(GenreRequest request);

    ListDataResponse<Cast> getGenres(GenreRequest request);

    Genre getGenre(Long id);

    Boolean deleteGenre(Long id);

}
