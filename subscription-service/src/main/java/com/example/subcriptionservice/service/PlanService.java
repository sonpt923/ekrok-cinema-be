package com.example.subcriptionservice.service;

import com.example.subcriptionservice.dto.request.PlanRequest;

public interface PlanService {

    Object createPlan(PlanRequest request);

    Object updatePlan(PlanRequest request);

    Object getPlan(Long id);

    Object getPlans(PlanRequest request);

    Object deletePlan(Long id);

}
