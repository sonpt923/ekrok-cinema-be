package com.example.sagaservice.dsl;

public interface  SagaStep {

    // Gửi command ra hệ thống (Kafka, RabbitMQ, etc.)
    SagaStep publish(Object command);

    // Chỉ định event success mà step này chờ đợi
    SagaStep onReply(Class<?> successEvent);

    // Chỉ định event failure
    SagaStep onFailure(Class<?> failureEvent);

    // Chỉ định command rollback (compensation action)
    SagaStep withCompensation(Object rollbackCommand);

}
