package com.example.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.Map;

@Document("history")
public class History {


    @Id
    private String id;

    @Field("template_code")
    private String templateCode; // mã template đã dùng

    @Field("channel")
    private String channel;      // EMAIL, INAPP, WEB_PUSH,...

    @Field("status")
    private String status;       // PENDING, SUCCESS, FAILED, RETRYING

    @Field("errorMessage")
    private String errorMessage; // nếu FAILED thì lưu lỗi ở đây

    @Field("receiver")
    private String receiver;     // email, userId, sđt,... tùy channel

    @Field("resolved_placeholders")
    private Map<String, Object> resolvedPlaceholders; // nội dung thực tế sau khi render

    @Field("sent_at")
    private Timestamp sentAt;

    @Field("retry_count")
    private int retryCount;

    @Field("created_by")
    private String createdBy;

    @Field("created_at")
    private Timestamp createdAt;


}
