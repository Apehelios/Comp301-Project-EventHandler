package org.yeditepe.eventcatalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yeditepe.eventcatalogservice.model.Event;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByCreatedByUserId(UUID createdByUserId);
}
