package com.eventplanner.eventcatalogservice.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    private String id;

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "category is required")
    private String category;

    private String description;

    @NotBlank(message = "location is required")
    private String location;

    @NotNull(message = "date is required")
    @Future(message = "date must be in the future")
    private LocalDateTime date;

    @Min(value = 1, message = "capacity must be at least 1")
    private int capacity;
}
