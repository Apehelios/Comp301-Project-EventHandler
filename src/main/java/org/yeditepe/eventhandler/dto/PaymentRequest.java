package org.yeditepe.eventhandler.dto;

import java.util.UUID;

public class PaymentRequest {

    private UUID bookingId;
    private UUID userId;
    private double amount;

    public PaymentRequest() {}

    public UUID getBookingId() { return bookingId; }
    public void setBookingId(UUID bookingId) { this.bookingId = bookingId; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
