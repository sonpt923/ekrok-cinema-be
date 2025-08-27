package com.example.sagaservice.messaging;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic paymentCommandTopic(){
        return TopicBuilder.name("")
                .partitions(1)
                .replicas(2)
                .compact()
                .build();
    }

}
