package org.yeditepe.userservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "auth_tokens")
public class AuthToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID token;

    @Column(nullable = false)
    private UUID userId;

    private LocalDateTime createdAt;

    public AuthToken() {}

    public AuthToken(UUID userId) {
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getToken() { return token; }
    public UUID getUserId() { return userId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
