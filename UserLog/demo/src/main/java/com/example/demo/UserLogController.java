package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class UserLogController {

    private final UserLogRepository repo;

    public UserLogController(UserLogRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public UserLog create(@RequestBody UserLog log) {
        log.setTimestamp(LocalDateTime.now());
        return repo.save(log);
    }

    @GetMapping
    public List<UserLog> list() {
        return repo.findAll();
    }
}