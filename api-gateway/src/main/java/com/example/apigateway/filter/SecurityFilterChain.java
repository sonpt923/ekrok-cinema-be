package com.example.apigateway.filter;

import com.example.apigateway.util.Constant;
import com.example.core.exception.BusinessException;
import com.example.core.exception.ValidateException;
import com.example.core.i18n.Dictionary;
import com.example.core.utils.BaseConstant;
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
import javax.ws.rs.HttpMethod;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

@Component
public class SecurityFilterChain extends OncePerRequestFilter {

    @Autowired
    private RouteValidator validator;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Dictionary dic;

    private static final Logger log = LoggerFactory.getLogger(SecurityFilterChain.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (validator.isSecure.test(request)) {
            String authenKey = request.getHeader(Constant.AUTHEN_KEY);

            if (request.getLocale() == null) {
                throw new ValidateException(BaseConstant.ERORRS.LOGIC, dic.get(""));
            }

            if (authenKey == null || authenKey.isBlank()) {
                throw new ValidateException(BaseConstant.ERORRS.NOT_NULL, String.format(dic.get("GW-001")));
            }

            String[] parts = authenKey.split(":");
            if (parts.length != 2) {
                throw new ValidateException(BaseConstant.ERORRS.INVALID_FORMAT, String.format(dic.get("GW-002")));
            }

            String userId = parts[0];
            String token = parts[1];
            String redisKey = Constant.USER_SESSION + ":" + userId + ":" + token;

            Object sessionJson = redisTemplate.opsForValue().get(redisKey);
            if (sessionJson == null) {
                throw new BusinessException(BaseConstant.ERORRS.DATA_NOT_FOUND, String.format(dic.get("GW-003")));
            }

            Map<String, Object> sessionInfo = new ObjectMapper().readValue(sessionJson.toString(), Map.class);
            String username = (String) sessionInfo.get("username");

            if (username == null || username.trim().isEmpty()) {
                throw new BusinessException(BaseConstant.ERORRS.DATA_NOT_FOUND, String.format(dic.get("GW-005")));
            }

            boolean exprireSession = redisTemplate.expire(redisKey, Duration.ofMinutes(30L));
            if (!exprireSession) {
                throw new BusinessException(BaseConstant.ERORRS.LOGIC, String.format(dic.get("GW-007")));
            }

            request.setAttribute("username", username);
            request.setAttribute("userId", userId);
            request.setAttribute("sessionkey", redisKey);

            log.info("Authenticated user: {} with token={}", username, token);
        }

        filterChain.doFilter(request, response);
    }
}
