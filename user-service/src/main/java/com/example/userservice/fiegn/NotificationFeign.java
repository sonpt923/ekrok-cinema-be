package com.example.userservice.fiegn;

import com.example.userservice.dto.request.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "${spring.rest.notification-service.name}")
public interface NotificationFeign {

    @PostMapping("/mail/send-otp")
    ResponseEntity sendOTP (@RequestBody UserRequest request);

}
