package com.example.movieservice.repository.customize;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.GenreRequest;

public interface GenreRepoCustom {

    ListDataResponse<Object> getGenres(GenreRequest request);

}
