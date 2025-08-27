package com.example.subcriptionservice.repository.customize;

import com.example.core.dto.response.ListDataResponse;
import com.example.subcriptionservice.dto.request.PlanRequest;

public interface PlanRepoCustomize {

    ListDataResponse<Object> getPlans(PlanRequest request);

}
