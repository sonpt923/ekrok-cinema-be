package com.example.movieservice.security;

import com.example.core.service.AuthorizationService;

public class AuthorizationServiceImpl implements AuthorizationService {
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
