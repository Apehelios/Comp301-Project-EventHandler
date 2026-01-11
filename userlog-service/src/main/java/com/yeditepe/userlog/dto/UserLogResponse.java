package com.yeditepe.userlog.dto;

import java.time.LocalDateTime;

public class UserLogResponse {
    private Long id;
    private LocalDateTime timestamp;
    private String serviceName;
    private String level;
    private String action;
    private String userId;
    private String username;
    private String correlationId;
    private String details;

    public UserLogResponse() {}

    public UserLogResponse(Long id, LocalDateTime timestamp, String serviceName, String level,
                           String action, String userId, String username, String correlationId, String details) {
        this.id = id;
        this.timestamp = timestamp;
        this.serviceName = serviceName;
        this.level = level;
        this.action = action;
        this.userId = userId;
        this.username = username;
        this.correlationId = correlationId;
        this.details = details;
    }

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getCorrelationId() { return correlationId; }
    public void setCorrelationId(String correlationId) { this.correlationId = correlationId; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}