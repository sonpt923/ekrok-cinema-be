package com.example.movieservice.service.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Genre;
import com.example.movieservice.service.LanguageService;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Override
    public Genre createLanguage(Genre genre) {
        return null;
    }

    @Override
    public Genre updateLanguage(Genre genre) {
        return null;
    }

    @Override
    public ListDataResponse<Object> getLanguages(GenreRequest request) {
        return null;
    }

    @Override
    public Genre getLanguage(GenreRequest request) {
        return null;
    }
}
