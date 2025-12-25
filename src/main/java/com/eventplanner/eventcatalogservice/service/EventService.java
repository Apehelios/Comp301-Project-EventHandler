package com.eventplanner.eventcatalogservice.service;

import com.eventplanner.eventcatalogservice.model.Event;
import com.eventplanner.eventcatalogservice.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;


    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }


    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}