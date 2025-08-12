package com.example.core.aop;

import com.example.core.annotation.RequireAuthor;
import com.example.core.exception.AuthorizationException;
import com.example.core.service.AuthorizationService;
import com.example.core.utils.RequestContextHolderUtils;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class AuthorizationAspect {

    private final AuthorizationService authorizationService;

    @Before("execution(* *(..)) && (@within(com.example.core.annotation.RequireAuthor) " +
            "|| @annotation(com.example.core.annotation.RequireAuthor))")
    public void checkPermission() {
        String token = RequestContextHolderUtils.getHeader("X-AUTH-TOKEN");
        String method = RequestContextHolderUtils.getMethod();
        String path = RequestContextHolderUtils.getPath();

        if (!authorizationService.checkPermission(token, method, path)) {
            throw new AuthorizationException("Không có quyền truy cập API này", "");
        }
    }

}
