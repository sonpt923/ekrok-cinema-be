package com.example.movieservice.service.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.movieservice.dto.request.SeasonRequest;
import com.example.movieservice.entity.Season;
import com.example.movieservice.service.SeasonService;
import org.springframework.stereotype.Service;

@Service
public class SeasonServiceImpl implements SeasonService {
    @Override
    public Season createSeason(SeasonRequest request) {
        return null;
    }

    @Override
    public Season updateSeason(SeasonRequest request) {
        return null;
    }

    @Override
    public ListDataResponse<Season> getSeasons(SeasonRequest request) {
        return null;
    }

    @Override
    public Season getSeason(Long id) {
        return null;
    }

    @Override
    public Boolean deleteSeason(Long id) {
        return null;
    }
}
