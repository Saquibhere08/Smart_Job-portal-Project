package com.smartjobportal.controller;

import com.smartjobportal.dto.UserRequest;
import com.smartjobportal.entity.User;
import com.smartjobportal.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestBody UserRequest request) {

        User user = userService.registerUser(request);

        return ResponseEntity.ok(user);
    }
}