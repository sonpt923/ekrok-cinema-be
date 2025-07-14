package com.example.core.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends BaseCodeException {

    public BusinessException(String code) {
        super(code);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.FORBIDDEN;
    }

}
