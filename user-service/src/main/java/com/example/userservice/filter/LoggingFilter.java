package com.example.userservice.filter;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(LoggingFilter.class);
    private static final String TRACE_ID = "traceId";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        CachedBodyHttpServletRequest wrappedRequest = new CachedBodyHttpServletRequest(request);
        CachedBodyHttpServletResponse wrappedResponse = new CachedBodyHttpServletResponse(response);

        String traceId = MDC.get(TRACE_ID); // Đảm bảo traceId đã có từ filter trước đó

        try {
            String requestBody = new String(wrappedRequest.getCachedBody(), StandardCharsets.UTF_8);
            log.info("Incoming Request [{}] {} - traceId={} - Headers={} - Body={}",
                    request.getMethod(), request.getRequestURI(), traceId,
                    Collections.list(request.getHeaderNames()).stream()
                            .collect(Collectors.toMap(h -> h, request::getHeader)),
                    requestBody);

            filterChain.doFilter(wrappedRequest, wrappedResponse);

        } finally {
            String responseBody = new String(wrappedResponse.getCachedBody(), StandardCharsets.UTF_8);
            log.info("Outgoing Response {} - traceId={} - Status={} - Body={}",
                    request.getRequestURI(), traceId, response.getStatus(), responseBody);
            wrappedResponse.copyBodyToResponse();
        }
    }

}
