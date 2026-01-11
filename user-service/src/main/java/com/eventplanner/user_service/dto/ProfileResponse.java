package com.eventplanner.user_service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProfileResponse {
    private Long id;
    private String username;
    private String email;
    private String role;
    private String fullName;
    private String phone;
}
