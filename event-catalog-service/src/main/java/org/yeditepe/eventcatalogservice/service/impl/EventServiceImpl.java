package org.yeditepe.eventcatalogservice.service.impl;

import org.springframework.stereotype.Service;
import org.yeditepe.eventcatalogservice.dto.EventRequest;
import org.yeditepe.eventcatalogservice.dto.EventResponse;
import org.yeditepe.eventcatalogservice.model.Event;
import org.yeditepe.eventcatalogservice.repository.EventRepository;
import org.yeditepe.eventcatalogservice.service.EventService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    private EventResponse toResponse(Event e) {
        return new EventResponse(
                e.getId(),
                e.getTitle(),
                e.getDescription(),
                e.getLocation(),
                e.getEventDateTime() == null ? null : e.getEventDateTime().toString(),
                e.getPrice(),
                e.getCapacity(),
                e.getCreatedByUserId()
        );
    }

    @Override
    public EventResponse create(EventRequest request) {
        LocalDateTime dt = LocalDateTime.parse(request.getEventDateTime());

        Event event = new Event(
                request.getTitle(),
                request.getDescription(),
                request.getLocation(),
                dt,
                request.getPrice(),
                request.getCapacity(),
                request.getCreatedByUserId()
        );

        return toResponse(eventRepository.save(event));
    }

    @Override
    public EventResponse getById(UUID id) {
        Event e = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return toResponse(e);
    }

    @Override
    public List<EventResponse> getAll() {
        return eventRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventResponse> getByCreator(UUID userId) {
        return eventRepository.findByCreatedByUserId(userId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EventResponse update(UUID id, EventRequest request) {
        Event e = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        e.setTitle(request.getTitle());
        e.setDescription(request.getDescription());
        e.setLocation(request.getLocation());
        e.setEventDateTime(LocalDateTime.parse(request.getEventDateTime()));
        e.setPrice(request.getPrice());
        e.setCapacity(request.getCapacity());
        e.setCreatedByUserId(request.getCreatedByUserId());

        return toResponse(eventRepository.save(e));
    }

    @Override
    public void delete(UUID id) {
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event not found");
        }
        eventRepository.deleteById(id);
    }
}
