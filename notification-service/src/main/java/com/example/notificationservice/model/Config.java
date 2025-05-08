package com.example.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config {

    private String apiKey;

    private String from;

    private String region;

    private Map<String, Object> params; // {"timeout": 5000, "trackingEnabled": true}

}
