package com.example.apigateway.filter;

import com.example.apigateway.util.Constant;
import com.example.core.exception.ValidateException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class SecurityFilterChain extends OncePerRequestFilter {

    @Autowired
    private RouteValidator validator;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger log = LoggerFactory.getLogger(SecurityFilterChain.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (validator.isSecure.test(request)) {
            String authenKey = request.getHeader(Constant.AUTHEN_KEY);

            if (request.getLocale() == null) {
                throw new ValidateException("GW-006");
            }

            if (authenKey == null || authenKey.isBlank()) {
                throw new ValidateException("GW-001");
            }

            String[] parts = authenKey.split(":");
            if (parts.length != 2) {
                throw new ValidateException("GW-002");
            }

            String userId = parts[0];
            String token = parts[1];
            String redisKey = Constant.USER_SESSION + ":" + userId + ":" + token;

            Object sessionJson = redisTemplate.opsForValue().get(redisKey);
            if (sessionJson == null) {
                throw new ValidateException("GW-003");
            }

            Map<String, Object> sessionInfo = new ObjectMapper().readValue(sessionJson.toString(), Map.class);
            String username = (String) sessionInfo.get("username");

            request.setAttribute("username", username);
            request.setAttribute("userId", userId);

            log.info("Authenticated user: {} with token={}", username, token);
        }

        filterChain.doFilter(request, response);
    }
}
