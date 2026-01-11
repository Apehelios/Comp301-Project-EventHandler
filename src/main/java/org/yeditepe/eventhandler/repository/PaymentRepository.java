package org.yeditepe.eventhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yeditepe.eventhandler.model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    List<Payment> findByUserId(UUID userId);

    List<Payment> findByBookingId(UUID bookingId);
}
