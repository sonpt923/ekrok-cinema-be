package com.example.movieservice.service.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Cast;
import com.example.movieservice.entity.Genre;
import com.example.movieservice.repository.GenreRepository;
import com.example.movieservice.repository.customize.GenreRepoCustom;
import com.example.movieservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepo;

    @Autowired
    private GenreRepoCustom genreRepoCustom;


    @Override
    public Genre createCast(GenreRequest request) {
        return null;
    }

    @Override
    public Genre updateCast(GenreRequest request) {
        return null;
    }

    @Override
    public ListDataResponse<Cast> getCasts(GenreRequest request) {
        return null;
    }

    @Override
    public Genre getCast(Long id) {
        return null;
    }

    @Override
    public Boolean deleteCast(Long id) {
        return null;
    }
}
