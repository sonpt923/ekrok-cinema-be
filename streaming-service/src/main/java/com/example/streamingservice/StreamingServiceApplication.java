package com.example.streamingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableDiscoveryClient
@EnableFeignClients
public class StreamingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamingServiceApplication.class, args);
	}

}
