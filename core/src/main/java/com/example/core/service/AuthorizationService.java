package com.example.core.service;

public interface AuthorizationService {

    boolean checkPermission(String token, String method, String path);

}
