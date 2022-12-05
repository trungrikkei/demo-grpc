package com.rikkeisoft.grpc_marketplace.controller;

import com.rikkeisoft.grpc_marketplace.service.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserServiceClient userServiceClient;

    @GetMapping("/user/getUsername")
    public String getUsername(@RequestParam Long userId) {
        return userServiceClient.getUsername(userId);
    }

    @PostMapping("/user/update")
    public String updateUser() {
        return userServiceClient.upDateUser() ? "SUCCESS" : "FAILED";
    }
}
