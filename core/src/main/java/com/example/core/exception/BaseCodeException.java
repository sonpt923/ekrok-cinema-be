package com.example.core.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseCodeException extends RuntimeException {

    private final String code;

    private final String messageOverride;

    public BaseCodeException(String code, String messageOverride) {
        super(messageOverride != null ? messageOverride : code); // để `getMessage()` return override
        this.code = code;
        this.messageOverride = messageOverride;
    }

    public String getMessageOverride() {
        return messageOverride;
    }

    public String getCode() {
        return code;
    }

    public abstract HttpStatus getHttpStatus();

}
