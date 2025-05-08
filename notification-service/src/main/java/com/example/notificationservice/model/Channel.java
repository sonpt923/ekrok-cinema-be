package com.example.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection = "channel")
public class Channel {

    @Id
    private String id;

    private String channelType;

    private String provider;

    private Config config;

    private String status;

    private Integer priority; // nếu lỗi thì có sử dụng channel khác cùng type không

    private String createdAt;

    private Timestamp createdBy;

    private String updatedBy;

    private Timestamp updatedAt;

    private Timestamp deletedAt;



}
