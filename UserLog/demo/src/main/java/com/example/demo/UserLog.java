package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String action;
    private String service;
    private LocalDateTime timestamp;

    public UserLog() {}

    public Long getId() { return id; }
    public String getUserId() { return userId; }
    public String getAction() { return action; }
    public String getService() { return service; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setUserId(String userId) { this.userId = userId; }
    public void setAction(String action) { this.action = action; }
    public void setService(String service) { this.service = service; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
