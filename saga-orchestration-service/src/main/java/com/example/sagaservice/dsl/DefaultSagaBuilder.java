package com.example.sagaservice.dsl;

import java.util.ArrayList;
import java.util.List;

public class DefaultSagaBuilder implements SagaBuilder{

    private final List<DefaultSagaStep> steps = new ArrayList<>();
    private DefaultSagaStep lastStep;

    @Override
    public SagaStep step(String name) {
        DefaultSagaStep step = new DefaultSagaStep(name);
        if (lastStep != null) {
            lastStep.addNextStep(step);
        }
        steps.add(step);
        lastStep = step;
        return step;
    }

    public List<DefaultSagaStep> getSteps() {
        return steps;
    }

}
