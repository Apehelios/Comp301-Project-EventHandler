package org.yeditepe.userservice.service;

import org.yeditepe.userservice.dto.*;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);

    List<UserResponse> listAll();

    UserResponse getById(UUID id);
    UserResponse getByEmail(String email);

    UserResponse deposit(UUID userId, double amount);
    UserResponse withdraw(UUID userId, double amount);
}
