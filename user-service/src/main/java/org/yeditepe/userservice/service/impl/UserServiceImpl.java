package org.yeditepe.userservice.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.yeditepe.userservice.dto.*;
import org.yeditepe.userservice.model.AuthToken;
import org.yeditepe.userservice.model.User;
import org.yeditepe.userservice.repository.AuthTokenRepository;
import org.yeditepe.userservice.repository.UserRepository;
import org.yeditepe.userservice.service.UserService;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthTokenRepository authTokenRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository, AuthTokenRepository authTokenRepository) {
        this.userRepository = userRepository;
        this.authTokenRepository = authTokenRepository;
    }

    private UserResponse toResponse(User u) {
        return new UserResponse(u.getId(), u.getFullName(), u.getEmail(), u.getBalance());
    }

    @Override
    public UserResponse register(RegisterRequest request) {
        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new RuntimeException("Email cannot be empty");
        }
        if (request.getPassword() == null || request.getPassword().length() < 4) {
            throw new RuntimeException("Password must be at least 4 characters");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        String hash = encoder.encode(request.getPassword());
        User user = new User(request.getFullName(), request.getEmail(), hash);

        return toResponse(userRepository.save(user));
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean ok = encoder.matches(request.getPassword(), user.getPasswordHash());
        if (!ok) throw new RuntimeException("Wrong password");

        AuthToken token = authTokenRepository.save(new AuthToken(user.getId()));
        return new LoginResponse(token.getToken(), toResponse(user));
    }

    @Override
    public List<UserResponse> listAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public UserResponse getById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toResponse(user);
    }

    @Override
    public UserResponse getByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toResponse(user);
    }

    @Override
    public UserResponse deposit(UUID userId, double amount) {
        if (amount <= 0) throw new RuntimeException("Amount must be > 0");

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setBalance(user.getBalance() + amount);
        return toResponse(userRepository.save(user));
    }

    @Override
    public UserResponse withdraw(UUID userId, double amount) {
        if (amount <= 0) throw new RuntimeException("Amount must be > 0");

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getBalance() < amount) throw new RuntimeException("Not enough balance");

        user.setBalance(user.getBalance() - amount);
        return toResponse(userRepository.save(user));
    }
}
