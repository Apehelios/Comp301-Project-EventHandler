package com.eventplanner.eventcatalogservice.repository;

import com.eventplanner.eventcatalogservice.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

}