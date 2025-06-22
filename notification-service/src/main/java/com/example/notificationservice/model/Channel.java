package com.example.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.Map;

@Document(collection = "channel")
public class Channel {

    @Id
    private String id;

    @Field("code")
    private String code;

    @Field("priority")
    private Long priority;

    @Field("provider")
    private String provider;

    @Field("configs")
    private Map<String, Object> configs;

    @Field("status")
    private String status;

    @Field("createdAt")
    private Timestamp createdAt;

    @Field("createdBy")
    private String createdBy;

    @Field("updatedBy")
    private String updatedBy;

    @Field("updatedAt")
    private Timestamp updatedAt;

    @Field("deleted")
    private Boolean deleted;
}
