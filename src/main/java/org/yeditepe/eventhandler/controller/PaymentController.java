package org.yeditepe.eventhandler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yeditepe.eventhandler.dto.PaymentRequest;
import org.yeditepe.eventhandler.dto.PaymentResponse;
import org.yeditepe.eventhandler.service.PaymentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> create(@RequestBody PaymentRequest request) {
        PaymentResponse created = paymentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(paymentService.getById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PaymentResponse>> getByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(paymentService.getByUserId(userId));
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<PaymentResponse>> getByBooking(@PathVariable UUID bookingId) {
        return ResponseEntity.ok(paymentService.getByBookingId(bookingId));
    }
}
