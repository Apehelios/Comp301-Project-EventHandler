package org.yeditepe.eventhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yeditepe.eventhandler.model.Booking;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    // "Find all bookings that belong to this user"
    List<Booking> findByUserId(UUID userId);
}

