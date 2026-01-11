package org.yeditepe.eventhandler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yeditepe.eventhandler.dto.BookingRequest;
import org.yeditepe.eventhandler.dto.BookingResponse;
import org.yeditepe.eventhandler.service.BookingService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponse> create(@RequestBody BookingRequest request) {
        BookingResponse created = bookingService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(bookingService.getById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingResponse>> getByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(bookingService.getByUserId(userId));
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<BookingResponse> cancel(@PathVariable UUID id) {
        return ResponseEntity.ok(bookingService.cancel(id));
    }
}
