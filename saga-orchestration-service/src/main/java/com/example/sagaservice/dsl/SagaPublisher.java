package com.example.sagaservice.dsl;

public interface SagaPublisher {

    void publish(Object message, SagaExecutionContext context);

}
