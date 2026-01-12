package org.yeditepe.paymentservice.dto;

import java.util.UUID;

public class PaymentRequest {

    private UUID bookingId;
    private double amount;

    public PaymentRequest() {
    }

    public UUID getBookingId() { return bookingId; }
    public void setBookingId(UUID bookingId) { this.bookingId = bookingId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
