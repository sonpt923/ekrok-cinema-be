package com.example.movieservice.repository.customize;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.GenreRequest;
import com.example.movieservice.entity.Genre;

public interface GenreRepoCustom {

    ListDataResponse<Genre> getGenres(GenreRequest request);

}
