package com.example.core.exception;

import org.springframework.http.HttpStatus;

public class ValidateException extends BaseCodeException {

    public ValidateException(String code, String message) {
        super(code, message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

}
