package com.example.apigateway.filter;

import com.example.apigateway.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (validator.isSecure.test(request)) {
            String authenKey = request.getHeader(Constant.AUTHEN_KEY);

            Assert.isNull(Constant.ERROR_NOT_NULL, "phai chuyen authen-key nhe cu");

            String[] parts = authenKey.split(":");
            if (parts.length != 2) {
//
            }

            String redisKey = Constant.USER_SESSION + ":" + parts[0];
            String fieldKey = parts[1];

            Map<String, Object> sessionInfo = new ObjectMapper().readValue(redisTemplate.opsForValue().get(redisKey + ":" + fieldKey).toString(), Map.class);
            if (sessionInfo == null) {
//                throw new ValidationException("SS001", "Session not found or expired");
            }
            request.setAttribute("username", sessionInfo.get("username"));
        }
        filterChain.doFilter(request, response);
    }
}
