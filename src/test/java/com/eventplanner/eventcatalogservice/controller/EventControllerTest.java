package com.eventplanner.eventcatalogservice.controller;

import com.eventplanner.eventcatalogservice.model.Event;
import com.eventplanner.eventcatalogservice.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EventControllerTest {

    private MockMvc mockMvc;
    private EventService eventService;

    @BeforeEach
    void setup() {
        eventService = mock(EventService.class);
        EventController controller = new EventController(eventService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getEventById_whenMissing_returns404() throws Exception {
        when(eventService.getById("404")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/events/404")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getEventById_whenExists_returns200() throws Exception {
        Event e = new Event(
                "1", "Title", "Category", "Desc", "Location",
                LocalDateTime.now().plusDays(2), 5
        );
        when(eventService.getById("1")).thenReturn(Optional.of(e));

        mockMvc.perform(get("/api/events/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
