package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Cast;
import com.example.movieservice.entity.Genre;
import com.example.movieservice.entity.Movie;

import java.util.List;

public interface GenreService {

    Genre createGenre(GenreRequest request, String username);

    Genre updateGenre(GenreRequest request, String username);

    ListDataResponse<Cast> getGenres(GenreRequest request);

    Genre getGenre(Long id);

    Boolean deleteGenre(Long id, String username);

}
