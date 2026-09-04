package com.smartjobportal.service;

import com.smartjobportal.dto.LoginRequest;
import com.smartjobportal.dto.LoginResponse;
import com.smartjobportal.dto.UserRequest;
import com.smartjobportal.entity.User;
import com.smartjobportal.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // =========================
    // REGISTER USER
    // =========================

    public User registerUser(UserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException(
                    "Email already registered"
            );
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Encrypt password before saving
        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setPhone(request.getPhone());
        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    // =========================
    // LOGIN USER
    // =========================

    public LoginResponse loginUser(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Invalid email or password"
                        )
                );

        // Compare entered password
        // with BCrypt password from database
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid email or password"
            );
        }

        // Generate JWT
        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return new LoginResponse(
                "Login successful",
                token
        );
    }

    // =========================
    // GET ALL USERS
    // =========================

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // =========================
    // GET USER BY ID
    // =========================

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found with id: " + id
                        )
                );
    }

    // =========================
    // UPDATE USER
    // =========================

    public User updateUser(
            Long id,
            UserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found with id: " + id
                        )
                );

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Encrypt updated password
        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setPhone(request.getPhone());
        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    // =========================
    // DELETE USER
    // =========================

    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException(
                    "User not found with id: " + id
            );
        }

        userRepository.deleteById(id);
    }
}