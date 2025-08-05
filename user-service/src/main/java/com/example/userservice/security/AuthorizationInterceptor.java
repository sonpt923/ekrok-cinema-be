package com.example.userservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String userId = request.getHeader("X-User-Id");
        if (userId == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        String method = request.getMethod();
        String uri = request.getRequestURI();

//        String permissionRequired = apiPermissionMapper.getPermissionCode(uri, method);
//        if (permissionRequired == null) {
//            // Không cần quyền, cho qua
//            return true;
//        }

        List<String> userPermissions = (List<String>) redisTemplate.opsForValue().get("USER_PERMISSION::" + userId);
        if (userPermissions == null || !userPermissions.contains("permissionRequired")) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return false;
        }

        return true;
    }
}
