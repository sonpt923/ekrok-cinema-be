package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Genre;

public interface LanguageService {

    Genre createLanguage(Genre genre);

    Genre updateLanguage(Genre genre);

    ListDataResponse<Object> getLanguages(GenreRequest request);

    Genre getLanguage(GenreRequest request);

}
