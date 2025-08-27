package com.example.sagaservice.dsl;

import java.util.ArrayList;
import java.util.List;

public class DefaultSagaStep implements SagaStep{

    private final String name;
    private Object command;
    private Class<?> successEvent;
    private Class<?> failureEvent;
    private Object compensationCommand;

    private final List<DefaultSagaStep> nextSteps = new ArrayList<>();

    public DefaultSagaStep(String name) {
        this.name = name;
    }

    @Override
    public SagaStep publish(Object command) {
        this.command = command;
        return this;
    }

    @Override
    public SagaStep onReply(Class<?> successEvent) {
        this.successEvent = successEvent;
        return this;
    }

    @Override
    public SagaStep onFailure(Class<?> failureEvent) {
        this.failureEvent = failureEvent;
        return this;
    }

    @Override
    public SagaStep withCompensation(Object rollbackCommand) {
        this.compensationCommand = rollbackCommand;
        return this;
    }

    public String getName() {
        return name;
    }

    public Object getCommand() {
        return command;
    }

    public Class<?> getSuccessEvent() {
        return successEvent;
    }

    public Class<?> getFailureEvent() {
        return failureEvent;
    }

    public Object getCompensationCommand() {
        return compensationCommand;
    }

    public void addNextStep(DefaultSagaStep step) {
        nextSteps.add(step);
    }

    public List<DefaultSagaStep> getNextSteps() {
        return nextSteps;
    }

}
