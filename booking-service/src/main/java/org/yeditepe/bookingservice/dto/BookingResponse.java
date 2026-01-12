package org.yeditepe.bookingservice.dto;

import org.yeditepe.bookingservice.model.BookingStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingResponse {

    private UUID id;
    private UUID userId;
    private UUID eventId;
    private int seatCount;
    private BookingStatus status;
    private LocalDateTime createdAt;

    public BookingResponse() {
    }

    public BookingResponse(UUID id, UUID userId, UUID eventId, int seatCount, BookingStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.eventId = eventId;
        this.seatCount = seatCount;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public UUID getUserId() { return userId; }
    public UUID getEventId() { return eventId; }
    public int getSeatCount() { return seatCount; }
    public BookingStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
