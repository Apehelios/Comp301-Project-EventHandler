package org.yeditepe.paymentservice.dto;

import org.yeditepe.paymentservice.model.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentResponse {

    private UUID id;
    private UUID bookingId;
    private double amount;
    private PaymentStatus status;
    private LocalDateTime createdAt;

    public PaymentResponse() {
    }

    public PaymentResponse(UUID id, UUID bookingId, double amount, PaymentStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public UUID getBookingId() { return bookingId; }
    public double getAmount() { return amount; }
    public PaymentStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
