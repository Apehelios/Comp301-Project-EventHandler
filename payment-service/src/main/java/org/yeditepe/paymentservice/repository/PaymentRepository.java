package org.yeditepe.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yeditepe.paymentservice.model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    List<Payment> findByBookingId(UUID bookingId);
}
