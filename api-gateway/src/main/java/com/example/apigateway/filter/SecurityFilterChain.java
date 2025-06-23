package com.example.apigateway.filter;

import com.example.apigateway.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.util.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
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
        try {
            if (validator.isSecure.test(request)) {
                String authenKey = request.getHeader(Constant.AUTHEN_KEY);

                if (authenKey == null || authenKey.isBlank()) {
                    reject(response, "Missing authen-key");
                    return;
                }

                String[] parts = authenKey.split(":");
                if (parts.length != 2) {
                    reject(response, "Invalid authen-key format. Expected userId:token");
                    return;
                }

                String userId = parts[0];
                String token = parts[1];
                String redisKey = Constant.USER_SESSION + ":" + userId + ":" + token;

                String sessionJson = redisTemplate.opsForValue().get(redisKey).toString();
                if (sessionJson == null) {
                    reject(response, "Session not found or expired");
                    return;
                }

                Map<String, Object> sessionInfo = new ObjectMapper().readValue(sessionJson, Map.class);
                String username = (String) sessionInfo.get("username");

                request.setAttribute("username", username);
                request.setAttribute("userId", userId);

                MDC.put("userId", userId);
                MDC.put("username", username);

                log.info("Authenticated user: {} with token={}", username, token);
            }

            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("userId");
            MDC.remove("username");
        }
    }

    private void reject(HttpServletResponse response, String message) throws IOException {
        log.warn("Rejected request: {}", message);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"" + message + "\"}");
    }
}
