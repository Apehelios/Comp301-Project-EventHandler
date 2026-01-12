package org.yeditepe.eventcatalogservice.dto;

import java.util.UUID;

public class EventRequest {

    private String title;
    private String description;
    private String location;
    private String eventDateTime; // ISO: "2026-02-01T20:00:00"
    private double price;
    private int capacity;
    private UUID createdByUserId;

    public EventRequest() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getEventDateTime() { return eventDateTime; }
    public void setEventDateTime(String eventDateTime) { this.eventDateTime = eventDateTime; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public UUID getCreatedByUserId() { return createdByUserId; }
    public void setCreatedByUserId(UUID createdByUserId) { this.createdByUserId = createdByUserId; }
}
