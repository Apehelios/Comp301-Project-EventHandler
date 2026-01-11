package com.eventplanner.user_service.service;

import com.eventplanner.user_service.dto.*;
import com.eventplanner.user_service.entity.User;
import com.eventplanner.user_service.exception.ApiException;
import com.eventplanner.user_service.repository.UserRepository;
import com.eventplanner.user_service.security.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository repo, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public void register(RegisterRequest req) {
        if (repo.existsByEmail(req.getEmail())) throw new ApiException("Email already exists");
        if (repo.existsByUsername(req.getUsername())) throw new ApiException("Username already exists");

        User user = User.builder()
                .username(req.getUsername())
                .email(req.getEmail())
                .passwordHash(encoder.encode(req.getPassword()))
                .fullName(req.getFullName())
                .phone(req.getPhone())
                .role("ROLE_USER")
                .build();

        repo.save(user);
    }

    public AuthResponse login(LoginRequest req) {
        User user = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new ApiException("Invalid credentials"));

        if (!encoder.matches(req.getPassword(), user.getPasswordHash())) {
            throw new ApiException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return new AuthResponse(token);
    }

    public ProfileResponse me(Authentication auth) {
        String email = auth.getName();
        User user = repo.findByEmail(email).orElseThrow(() -> new ApiException("User not found"));

        return ProfileResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .build();
    }

    public ProfileResponse updateMe(Authentication auth, UpdateProfileRequest req) {
        String email = auth.getName();
        User user = repo.findByEmail(email).orElseThrow(() -> new ApiException("User not found"));

        user.setFullName(req.getFullName());
        user.setPhone(req.getPhone());
        repo.save(user);

        return me(auth);
    }
}
