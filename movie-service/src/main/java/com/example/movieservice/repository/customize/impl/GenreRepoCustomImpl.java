package com.example.movieservice.repository.customize.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.repository.customize.GenreRepoCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GenreRepoCustomImpl implements GenreRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public ListDataResponse<Object> getGenres(GenreRequest request) {
        return null;
    }
}
