package com.smartjobportal.service;

import com.smartjobportal.dto.UserRequest;
import com.smartjobportal.entity.User;
import com.smartjobportal.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());

        return userRepository.save(user);
    }
}