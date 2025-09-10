package com.example.movieservice.service;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.SeasonRequest;
import com.example.movieservice.entity.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface SeasonService {

    Season createSeason(SeasonRequest request);

    Season updateSeason(SeasonRequest request);

    ListDataResponse<Season> getSeasons(SeasonRequest request);

    Season getSeason(Long id);

    Boolean deleteSeason(Long id);


}
