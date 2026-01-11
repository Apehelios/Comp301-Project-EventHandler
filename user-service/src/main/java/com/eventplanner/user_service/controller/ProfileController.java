package com.eventplanner.user_service.controller;

import com.eventplanner.user_service.dto.ProfileResponse;
import com.eventplanner.user_service.dto.UpdateProfileRequest;
import com.eventplanner.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ProfileResponse me(Authentication auth) {
        return userService.me(auth);
    }

    @PutMapping("/me")
    public ProfileResponse updateMe(Authentication auth,
                                    @Valid @RequestBody UpdateProfileRequest req) {
        return userService.updateMe(auth, req);
    }
}
