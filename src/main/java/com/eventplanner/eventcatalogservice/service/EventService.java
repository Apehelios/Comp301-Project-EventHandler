package com.eventplanner.eventcatalogservice.service;

import com.eventplanner.eventcatalogservice.model.Event;
import com.eventplanner.eventcatalogservice.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getById(String id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> updateEvent(String id, Event updated) {
        return eventRepository.findById(id).map(existing -> {
            existing.setTitle(updated.getTitle());
            existing.setCategory(updated.getCategory());
            existing.setDescription(updated.getDescription());
            existing.setLocation(updated.getLocation());
            existing.setDate(updated.getDate());
            existing.setCapacity(updated.getCapacity());
            return eventRepository.save(existing);
        });
    }
}
