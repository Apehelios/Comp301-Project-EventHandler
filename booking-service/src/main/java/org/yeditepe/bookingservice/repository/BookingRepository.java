package org.yeditepe.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yeditepe.bookingservice.model.Booking;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    List<Booking> findByUserId(UUID userId);
}
