package com.example.core.aop;

import com.example.core.dto.response.ErrorResponse;
import com.example.core.exception.BaseCodeException;
import com.example.core.exception.BusinessException;
import com.example.core.exception.SystemException;
import com.example.core.exception.ValidateException;
import com.example.core.i18n.Dictionary;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ExceptionHandlingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final HttpServletRequest request;

    @Autowired
    private Dictionary dictionary;

    public ExceptionHandlingAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Around("execution(* com.example..controller..*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (BaseCodeException bce) {
            String code = bce.getCode();
            String message = bce.getMessageOverride();
            ErrorResponse err = ErrorResponse.of(code, message, request.getRequestURI());

            if (bce instanceof SystemException) {
                log.error("SystemException: code={}, msg={}", code, message, bce);
            } else if (bce instanceof ValidateException) {
                log.error("ValidateException: code={}, msg={}", code, message, bce);
            } else if (bce instanceof BusinessException) {
                log.error("BuinessException: code={}, msg={}", code, message, bce);
            } else {
                log.warn("{}: code={}, msg={}", bce.getClass().getSimpleName(), code, message);
            }

            return ResponseEntity
                    .status(bce.getHttpStatus())
                    .body(err);
        } catch (Throwable t) {
            log.error("Unhandled exception: {}", t);
            ErrorResponse err = ErrorResponse.of(
                    "9125",
                    dictionary.get("unhandle exception"),
                    request.getRequestURI());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(err);
        }
    }

}
