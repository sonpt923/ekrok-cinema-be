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
    public Genre createGenre(GenreRequest request) {
        return null;
    }

    @Override
    public Genre updateGenre(GenreRequest request) {
        return null;
    }

    @Override
    public ListDataResponse<Cast> getGenres(GenreRequest request) {
        return null;
    }

    @Override
    public Genre getGenre(Long id) {
        return null;
    }

    @Override
    public Boolean deleteGenre(Long id) {
        return null;
    }

    private void validateCreateGenre(GenreRequest request){

    }

    private void validateUpdateGenre(GenreRequest request){

    }

    private void validateGenre(GenreRequest request){

    }

}
