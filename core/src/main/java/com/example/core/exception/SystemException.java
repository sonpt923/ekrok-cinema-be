package com.example.core.exception;

import org.springframework.http.HttpStatus;

public class SystemException extends BaseCodeException {

    public SystemException(String code) {
        super(code);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
