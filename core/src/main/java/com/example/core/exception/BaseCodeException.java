package com.example.core.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseCodeException extends RuntimeException {

    private final String code;

    public BaseCodeException(String code) {
        super(code);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public abstract HttpStatus getHttpStatus();

}
