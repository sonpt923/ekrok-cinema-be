package com.example.core.exception;

import org.springframework.http.HttpStatus;

public class SystemException extends BaseCodeException {

    public SystemException(String code, String message) {
        super(code, message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
