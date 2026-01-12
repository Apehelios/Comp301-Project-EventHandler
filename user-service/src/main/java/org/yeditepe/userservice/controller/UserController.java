package org.yeditepe.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yeditepe.userservice.dto.*;
import org.yeditepe.userservice.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    // Needed for dropdown
    @GetMapping
    public ResponseEntity<List<UserResponse>> listAll() {
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> getByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<UserResponse> deposit(
            @PathVariable("id") UUID id,
            @RequestParam("amount") double amount
    ) {
        return ResponseEntity.ok(userService.deposit(id, amount));
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<UserResponse> withdraw(
            @PathVariable("id") UUID id,
            @RequestParam("amount") double amount
    ) {
        return ResponseEntity.ok(userService.withdraw(id, amount));
    }
}
