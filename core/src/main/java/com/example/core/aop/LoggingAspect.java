package com.example.core.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;
import org.slf4j.MDC;

@Aspect
@Component
public class LoggingAspect {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.example.*.service..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String traceId = UUID.randomUUID().toString();
        MDC.put("traceId", traceId);

        String method = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        log.info(" [{}] : =====================================>START<===================================== ", traceId);
        log.info(" [{}] [START] : {} with args: {}", traceId, method, safeJson(Arrays.toString(args)));

        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;
            log.info(" [{}] [END] : {} returned: {} ({} ms)", traceId, method, safeJson(result), duration);
            return result;
        } catch (Throwable ex) {
            log.error("[{}] [EXCEPTION] in {}: {}", traceId, method, safeJson(ex.getMessage()), ex);
            throw ex;
        } finally {
            MDC.clear();
        }
    }

    private String safeJson(Object obj) {
        try {
            String json = objectMapper.writeValueAsString(obj);
            if (json.length() > 300) return json.substring(0, 300) + " ...";
            return json;
        } catch (Exception e) {
            return "[unserializable]";
        }
    }
}
