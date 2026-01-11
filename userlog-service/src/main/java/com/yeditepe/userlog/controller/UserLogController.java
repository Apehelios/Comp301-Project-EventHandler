package com.yeditepe.userlog.controller;

import com.yeditepe.userlog.dto.UserLogCreateRequest;
import com.yeditepe.userlog.dto.UserLogResponse;
import com.yeditepe.userlog.service.UserLogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class UserLogController {

    private final UserLogService service;

    public UserLogController(UserLogService service) {
        this.service = service;
    }

    // POST /logs
    @PostMapping
    public ResponseEntity<UserLogResponse> create(
            @Valid @RequestBody UserLogCreateRequest request) {

        return ResponseEntity.ok(service.create(request));
    }

    // GET /logs
    @GetMapping
    public ResponseEntity<List<UserLogResponse>> getAll() {
        List<UserLogResponse> list = service.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    // GET /logs/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserLogResponse>> getByUserId(@PathVariable String userId) {
        List<UserLogResponse> list = service.getByUserId(userId);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    // GET /logs/action/{action}
    @GetMapping("/action/{action}")
    public ResponseEntity<List<UserLogResponse>> getByAction(@PathVariable String action) {
        List<UserLogResponse> list = service.getByAction(action);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    // GET /logs/service/{serviceName}
    @GetMapping("/service/{serviceName}")
    public ResponseEntity<List<UserLogResponse>> getByService(@PathVariable String serviceName) {
        List<UserLogResponse> list = service.getByServiceName(serviceName);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    // GET /logs/user/{userId}/action/{action}
    @GetMapping("/user/{userId}/action/{action}")
    public ResponseEntity<List<UserLogResponse>> getByUserIdAndAction(
            @PathVariable String userId,
            @PathVariable String action) {

        List<UserLogResponse> list = service.getByUserIdAndAction(userId, action);
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }
}
