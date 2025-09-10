package com.example.movieservice.repository.customize;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.CastRequest;
import com.example.movieservice.entity.Cast;

public interface CastRepoCustom {

    ListDataResponse<Cast> getCasts(CastRequest request);

}
