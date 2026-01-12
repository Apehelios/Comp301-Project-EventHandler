package org.yeditepe.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yeditepe.userservice.model.AuthToken;

import java.util.List;
import java.util.UUID;

public interface AuthTokenRepository extends JpaRepository<AuthToken, UUID> {
    List<AuthToken> findByUserId(UUID userId);
}
