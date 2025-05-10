package com.example.apigateway.filter;

import com.example.exception.ValidationException;
import com.example.security.BaseJwtProvider;
import com.example.utils.BaseConstants;
import com.example.utils.StringUtil;
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

    @Autowired
    private BaseJwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (validator.isSecure.test(request)) {
            String authenKey = request.getHeader(BaseConstants.AUTHEN_KEY);

            if (StringUtil.stringIsNullOrEmty(authenKey)) {
                throw new ValidationException(BaseConstants.ERROR_NOT_NULL, "authen-key");
            }

            String[] parts = authenKey.split(":");
            if (parts.length != 2) {
                throw new ValidationException("AUTHEN001", "Expected format authen-key");
            }

            String redisKey = BaseConstants.USER_SESSION + ":" + parts[0];
            String fieldKey = parts[1];

            Map<String, Object> sessionInfo = (Map<String, Object>) redisTemplate.opsForHash().get(redisKey, fieldKey);
            if (sessionInfo == null) {
                throw new ValidationException("SS001", "Session not found or expired");
            }



        }
        filterChain.doFilter(request, response);
    }

}
