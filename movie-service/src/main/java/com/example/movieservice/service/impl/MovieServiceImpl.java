package com.example.movieservice.service.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.MovieRequest;
import com.example.movieservice.entity.Movie;
import com.example.movieservice.repository.MovieRepository;
import com.example.movieservice.service.MovieGenreService;
import com.example.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieGenreService movieGenreService;

    @Override
    public Object createMovie(MovieRequest movieRequest, String token) {
        validateCreate(movieRequest);
        return null;
    }

    @Override
    public Movie updateMovie(MovieRequest movieRequest, String username) {
        return null;
    }

    @Override
    public Movie getMovie(Long id) {
        return null;
    }

    @Override
    public ListDataResponse<Movie> getMovies(MovieRequest request) {
        return null;
    }

    @Override
    public Object deleteMovie(Long id) {
        return null;
    }

    private void validateCreate(MovieRequest movieRequest) {

    }

    private void validateUpdate(MovieRequest movieRequest){

    }
}
