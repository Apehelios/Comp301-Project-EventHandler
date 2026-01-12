package org.yeditepe.eventcatalogservice.service;

import org.yeditepe.eventcatalogservice.dto.EventRequest;
import org.yeditepe.eventcatalogservice.dto.EventResponse;

import java.util.List;
import java.util.UUID;

public interface EventService {
    EventResponse create(EventRequest request);
    EventResponse getById(UUID id);
    List<EventResponse> getAll();
    List<EventResponse> getByCreator(UUID userId);
    EventResponse update(UUID id, EventRequest request);
    void delete(UUID id);
}
