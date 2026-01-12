package org.yeditepe.paymentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yeditepe.paymentservice.dto.PaymentRequest;
import org.yeditepe.paymentservice.dto.PaymentResponse;
import org.yeditepe.paymentservice.service.PaymentService;

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
    public ResponseEntity<PaymentResponse> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(paymentService.getById(id));
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<PaymentResponse>> getByBooking(@PathVariable("bookingId") UUID bookingId) {
        return ResponseEntity.ok(paymentService.getByBookingId(bookingId));
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<PaymentResponse> complete(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(paymentService.complete(id));
    }

    @PostMapping("/{id}/fail")
    public ResponseEntity<PaymentResponse> fail(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(paymentService.fail(id));
    }
}
