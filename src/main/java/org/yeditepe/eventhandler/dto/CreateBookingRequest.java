package org.yeditepe.eventhandler.dto;

import java.util.UUID;

public class CreateBookingRequest {

    private UUID userId;
    private UUID eventId;
    private int ticketCount;

    public CreateBookingRequest() {}

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public UUID getEventId() { return eventId; }
    public void setEventId(UUID eventId) { this.eventId = eventId; }

    public int getTicketCount() { return ticketCount; }
    public void setTicketCount(int ticketCount) { this.ticketCount = ticketCount; }
}

