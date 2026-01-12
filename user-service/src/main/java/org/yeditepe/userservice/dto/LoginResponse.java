package org.yeditepe.userservice.dto;

import java.util.UUID;

public class LoginResponse {
    private UUID token;
    private UserResponse user;

    public LoginResponse() {}

    public LoginResponse(UUID token, UserResponse user) {
        this.token = token;
        this.user = user;
    }

    public UUID getToken() { return token; }
    public UserResponse getUser() { return user; }
}
