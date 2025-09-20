package com.example.movieservice.service.impl;

import com.example.movieservice.entity.Movie;
import com.example.movieservice.entity.MovieGenre;
import com.example.movieservice.service.MovieGenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieGenreServiceImpl implements MovieGenreService {
    @Override
    @Transactional
    public List<MovieGenre> createBatchMovieGenre(List<MovieGenre> listMovieGenre, Movie movie) {
        return List.of();
    }

    @Override
    @Transactional
    public List<MovieGenre> updateBatchMovieGenre(List<MovieGenre> listMovieGenre, Movie movie) {
        return List.of();
    }
}
