package com.example.core.exception;

import org.springframework.http.HttpStatus;

public class AuthorizationException extends BaseCodeException{

    public AuthorizationException(String code, String message) {
        super(code, message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

}
