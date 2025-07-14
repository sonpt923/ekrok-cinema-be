package com.example.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T> {

    private String code;
    private String message;
    private T data;
    private String timestamp;
    private String path;

    public static <T> BaseResponse<T> of(HttpStatus status, T data, String message, String path) {
        return new BaseResponse<>(
                String.valueOf(status.value()),
                message,
                data,
                Instant.now().toString(),
                path
        );
    }

}
