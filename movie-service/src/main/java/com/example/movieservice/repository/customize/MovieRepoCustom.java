package com.example.movieservice.repository.customize;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.MovieRequest;
import com.example.movieservice.entity.Movie;

public interface MovieRepoCustom {

    ListDataResponse<Movie> getMovies(MovieRequest request);

}
