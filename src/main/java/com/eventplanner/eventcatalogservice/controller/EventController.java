package com.eventplanner.eventcatalogservice.controller;

import com.eventplanner.eventcatalogservice.model.Event;
import com.eventplanner.eventcatalogservice.service.EventService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }


    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }
}