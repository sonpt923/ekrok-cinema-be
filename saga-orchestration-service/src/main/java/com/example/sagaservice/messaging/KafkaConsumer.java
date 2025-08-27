package com.example.sagaservice.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "payment-reply", groupId = "saga-orchestrator")
    public void handlePaymentReply(@Payload Object replyEvent) {
        System.out.println("[SAGA] Received reply: " + replyEvent);
        // TODO: Update SagaExecutionContext, move to next step
    }

    @KafkaListener(topics = "payment-rollback", groupId = "saga-orchestrator")
    public void handlePaymentRollback(@Payload Object rollbackEvent) {
        System.out.println("[SAGA] Received rollback: " + rollbackEvent);
        // TODO: Trigger rollback handling
    }

}
