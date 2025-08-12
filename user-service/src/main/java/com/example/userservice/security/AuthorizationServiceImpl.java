package com.example.userservice.security;

import com.example.core.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean checkPermission(String token, String method, String path) {
//        // 1. Lấy userId từ token trong Redis
//        String userId = (String) redisTemplate.opsForValue().get(token);
//        if (userId == null) return false;
//        Set<String> userPermissions = userClient.getUserPermissions(userId);
//        Set<String> apiPermissions = userClient.getApiPermissions(method, path);
        return false;
    }
}
