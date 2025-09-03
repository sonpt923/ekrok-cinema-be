package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.MovieRequest;
import com.example.movieservice.entity.Movie;

public interface MovieService {

    Object createMovie(MovieRequest movieRequest, String username);

    Movie updateMovie(MovieRequest movieRequest, String username);

    Movie getMovie(Long id);

    ListDataResponse<Movie> getMovies(MovieRequest request);

    Object deleteMovie(Long id);

}
