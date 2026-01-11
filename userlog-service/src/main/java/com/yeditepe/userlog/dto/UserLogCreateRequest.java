package com.yeditepe.userlog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLogCreateRequest {

    @NotBlank(message = "serviceName boş olamaz")
    @Size(max = 100, message = "serviceName en fazla 100 karakter olabilir")
    private String serviceName;

    @NotBlank(message = "level boş olamaz")
    @Size(max = 20, message = "level en fazla 20 karakter olabilir")
    private String level; // INFO, WARN, ERROR...

    @NotBlank(message = "action boş olamaz")
    @Size(max = 50, message = "action en fazla 50 karakter olabilir")
    private String action; // LOGIN, REGISTER...

    @NotBlank(message = "userId boş olamaz")
    @Size(max = 50, message = "userId en fazla 50 karakter olabilir")
    private String userId;

    @NotBlank(message = "username boş olamaz")
    @Size(max = 100, message = "username en fazla 100 karakter olabilir")
    private String username;

    @Size(max = 100, message = "correlationId en fazla 100 karakter olabilir")
    private String correlationId;

    @Size(max = 2000, message = "details en fazla 2000 karakter olabilir")
    private String details;

    // getters/setters

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