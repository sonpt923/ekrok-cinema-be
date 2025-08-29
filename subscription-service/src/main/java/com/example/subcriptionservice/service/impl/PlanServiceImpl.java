package com.example.subcriptionservice.service.impl;

import com.example.core.exception.ValidateException;
import com.example.core.utils.ObjectUtil;
import com.example.subcriptionservice.dto.request.PlanRequest;
import com.example.subcriptionservice.entity.Plan;
import com.example.subcriptionservice.repository.PlanRepository;
import com.example.subcriptionservice.repository.customize.PlanRepoCustomize;
import com.example.subcriptionservice.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PlanRepoCustomize planRepoCustomize;

    @Override
    public Object createPlan(PlanRequest request) {
        validateCreatePackage(request);
        Plan pack = Plan.builder().code(request.getCode()).name(request.getName())
                .description(request.getDescription()).price(request.getPrice())
                .duration(request.getDuration()).maxDevice(request.getMaxDevice())
                .quality(request.getQuality()).resolution(request.getResolution())
                .createdBy(request.getCreatedBy()).createdAt(null)
                .planParentId(request.getParentId()).build();
        pack = planRepository.save(pack);
        return pack;
    }

    @Override
    public Object updatePlan(PlanRequest request) {
        Plan plan = planRepository.findById(request.getId()).orElseThrow(() -> new ValidateException("s", "s"));
        validateUpdatePackage(request);
        plan = Plan.builder().code(request.getCode()).name(request.getName())
                .description(request.getDescription()).price(request.getPrice())
                .duration(request.getDuration()).maxDevice(request.getMaxDevice())
                .quality(request.getQuality()).resolution(request.getResolution())
                .updatedBy(request.getCreatedBy()).updatedAt(null).build();
        return planRepository.save(plan);
    }

    @Override
    public Object getPlan(Long id) {
        if (ObjectUtil.objectIsNullorEmpty(id)) {
            throw new ValidateException("", "");
        }
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new ValidateException("s", "s"));
        return plan;
    }

    @Override
    public Object getPlans(PlanRequest request) {
        return planRepoCustomize.getPlans(request);
    }

    @Override
    public Object deletePlan(Long id) {
        Plan plan = (Plan) this.getPlan(id);
        plan.setIsDeleted(true);
        return planRepository.save(plan);
    }

    private void validateCreatePackage(PlanRequest request) {

    }

    private void validateUpdatePackage(PlanRequest request) {

    }

}
