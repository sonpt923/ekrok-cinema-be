package com.example.core.aop;

import com.example.core.dto.response.BaseResponse;
import com.example.core.dto.response.ErrorResponse;
import com.example.core.i18n.Dictionary;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class ResponseWrappingAspect {

    private final HttpServletRequest request;
    private final Dictionary dictionary;

    public ResponseWrappingAspect(HttpServletRequest request, Dictionary dictionary) {
        this.request = request;
        this.dictionary = dictionary;
    }

    @Around("execution(* *..controller..*(..))")
    public Object wrapResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("⚡ AOP wrapResponse triggered: " + joinPoint.getSignature());
        Object result = joinPoint.proceed();

        if (result instanceof ResponseEntity) {
            Object body = ((ResponseEntity<?>) result).getBody();
            if (body instanceof ErrorResponse || body instanceof BaseResponse) return result;

            HttpStatus status = ((ResponseEntity<?>) result).getStatusCode();
            BaseResponse<Object> wrapped = BaseResponse.of(
                    status,
                    body,
                    dictionary.get("SUCCESS.GENERIC"),
                    request.getRequestURI()
            );
            return ResponseEntity.status(status).body(wrapped);
        }

        // Nếu controller return raw DTO (chưa gói trong ResponseEntity)
        BaseResponse<Object> wrapped = BaseResponse.of(
                HttpStatus.OK,
                result,
                dictionary.get("SUCCESS.GENERIC"),
                request.getRequestURI()
        );
        return ResponseEntity.ok(wrapped);
    }


}
