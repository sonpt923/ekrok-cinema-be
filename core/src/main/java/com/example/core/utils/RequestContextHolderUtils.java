package com.example.core.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

public class RequestContextHolderUtils {

    public static HttpServletRequest getRequest() {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        return (HttpServletRequest) attrs.resolveReference(RequestAttributes.REFERENCE_REQUEST);
    }

    public static String getHeader(String name) {
        return getRequest().getHeader(name);
    }

    public static String getMethod() {
        return getRequest().getMethod();
    }

    public static String getPath() {
        return getRequest().getRequestURI();
    }

}
