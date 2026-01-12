package org.yeditepe.userservice.dto;

import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String fullName;
    private String email;
    private double balance;

    public UserResponse() {}

    public UserResponse(UUID id, String fullName, String email, double balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.balance = balance;
    }

    public UUID getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public double getBalance() { return balance; }
}
