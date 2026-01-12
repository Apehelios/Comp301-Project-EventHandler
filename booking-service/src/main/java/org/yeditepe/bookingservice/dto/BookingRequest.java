package org.yeditepe.bookingservice.dto;

import java.util.UUID;

public class BookingRequest {

    private UUID userId;
    private UUID eventId;
    private int seatCount;

    public BookingRequest() {
    }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public UUID getEventId() { return eventId; }
    public void setEventId(UUID eventId) { this.eventId = eventId; }

    public int getSeatCount() { return seatCount; }
    public void setSeatCount(int seatCount) { this.seatCount = seatCount; }
}
