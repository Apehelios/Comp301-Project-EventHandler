package org.yeditepe.paymentservice.service;

import org.yeditepe.paymentservice.dto.PaymentRequest;
import org.yeditepe.paymentservice.dto.PaymentResponse;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentResponse create(PaymentRequest request);
    PaymentResponse getById(UUID id);
    List<PaymentResponse> getByBookingId(UUID bookingId);
    PaymentResponse complete(UUID id);
    PaymentResponse fail(UUID id);
}
