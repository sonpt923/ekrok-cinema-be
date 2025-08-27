package com.example.sagaservice.messaging;

import com.example.sagaservice.dsl.SagaExecutionContext;
import com.example.sagaservice.dsl.SagaPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer implements SagaPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    private String resolveTopic(Object command) {
        // Best practice: Map class -> topic name
        // Có thể dùng annotation @SagaTopic hoặc config map
        String className = command.getClass().getSimpleName().toLowerCase();
        if (className.contains("payment")) return "payment-command";
        if (className.contains("rollback")) return "payment-rollback";
        return "default-command";
    }

    @Override
    public void publish(Object message, SagaExecutionContext context) {

    }
}
