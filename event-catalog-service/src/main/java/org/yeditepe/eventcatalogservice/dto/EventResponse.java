package org.yeditepe.eventcatalogservice.dto;

import java.util.UUID;

public class EventResponse {

    private UUID id;
    private String title;
    private String description;
    private String location;
    private String eventDateTime;
    private double price;
    private int capacity;
    private UUID createdByUserId;

    public EventResponse() {}

    public EventResponse(UUID id, String title, String description, String location,
                         String eventDateTime, double price,
                         int capacity, UUID createdByUserId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.eventDateTime = eventDateTime;
        this.price = price;
        this.capacity = capacity;
        this.createdByUserId = createdByUserId;
    }

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getEventDateTime() { return eventDateTime; }
    public double getPrice() { return price; }
    public int getCapacity() { return capacity; }
    public UUID getCreatedByUserId() { return createdByUserId; }
}
