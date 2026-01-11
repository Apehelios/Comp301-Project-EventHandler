package com.eventplanner.user_service.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequest {

    @Size(max = 120)
    private String fullName;

    @Size(max = 30)
    private String phone;
}
