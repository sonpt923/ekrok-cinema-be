package com.example.core.aop;

import com.example.core.dto.response.ErrorResponse;
import com.example.core.exception.BaseCodeException;
import com.example.core.exception.SystemException;
import com.example.core.i18n.MessageResolver;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ExceptionHandlingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final HttpServletRequest request;
    private final MessageResolver messageResolver;

    public ExceptionHandlingAspect(HttpServletRequest request, MessageResolver messageResolver) {
        this.request = request;
        this.messageResolver = messageResolver;
    }

    @Around("execution(* com.example..controller..*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (BaseCodeException bce) {
            String code = bce.getCode();
            String message = messageResolver.resolve(code, request.getLocale());
            ErrorResponse err = ErrorResponse.of(code, message, request.getRequestURI());

            if (bce instanceof SystemException) {
                log.error("SystemException: code={}, msg={}", code, message, bce);
            } else {
                log.warn("{}: code={}, msg={}", bce.getClass().getSimpleName(), code, message);
            }

            return ResponseEntity
                    .status(bce.getHttpStatus())
                    .body(err);
        } catch (Throwable t) {
            log.error("Unhandled exception", t);
            ErrorResponse err = ErrorResponse.of(
                    "9999",
                    messageResolver.resolve("9999", request.getLocale()),
                    request.getRequestURI());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(err);
        }
    }

}
