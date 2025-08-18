package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Genre;

public interface GenreService {

    Genre createGenre(Genre genre);

    Genre updateGenre(Genre genre);

    ListDataResponse<Object> getGenres(GenreRequest request);

    Genre getGenre(GenreRequest request);

}
