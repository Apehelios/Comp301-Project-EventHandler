package com.yeditepe.userlog.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="user_logs")
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    LocalDateTime timestamp;

    String serviceName;   // logu hangi servis attı? (user-service, event-service...)
    String level;         // INFO, WARN, ERROR
    String action;        // LOGIN, REGISTER, EVENT_CREATED...

    String userId;
    String username;

    String correlationId; // servisler arası istek zinciri için

    @Column(length = 4000)
    String details;       // serbest açıklama / json metni

    public UserLog() {
    }

    public UserLog(String serviceName, String level, String action) {
        this.serviceName = serviceName;
        this.level = level;
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }

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
