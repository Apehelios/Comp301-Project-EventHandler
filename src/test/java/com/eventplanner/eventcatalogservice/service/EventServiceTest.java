package com.eventplanner.eventcatalogservice.service;

import com.eventplanner.eventcatalogservice.model.Event;
import com.eventplanner.eventcatalogservice.repository.EventRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EventServiceTest {

    @Test
    void updateEvent_whenExists_updatesAndReturns() {
        EventRepository repo = mock(EventRepository.class);
        EventService service = new EventService(repo);

        Event existing = new Event(
                "1",
                "Old Title",
                "Old Category",
                "Old Desc",
                "Old Location",
                LocalDateTime.now().plusDays(2),
                10
        );

        when(repo.findById("1")).thenReturn(Optional.of(existing));
        when(repo.save(any(Event.class))).thenAnswer(inv -> inv.getArgument(0));

        Event updated = new Event(
                null,
                "New Title",
                "New Category",
                "New Desc",
                "New Location",
                LocalDateTime.now().plusDays(3),
                20
        );

        Optional<Event> result = service.updateEvent("1", updated);

        assertTrue(result.isPresent());
        assertEquals("New Title", result.get().getTitle());
        assertEquals("New Category", result.get().getCategory());
        assertEquals(20, result.get().getCapacity());
        verify(repo).save(any(Event.class));
    }

    @Test
    void updateEvent_whenMissing_returnsEmpty() {
        EventRepository repo = mock(EventRepository.class);
        EventService service = new EventService(repo);

        when(repo.findById("404")).thenReturn(Optional.empty());

        Optional<Event> result = service.updateEvent("404", new Event());

        assertTrue(result.isEmpty());
        verify(repo, never()).save(any());
    }
}
