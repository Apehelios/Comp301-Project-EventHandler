package org.yeditepe.eventhandler.service;

import org.yeditepe.eventhandler.dto.PaymentRequest;
import org.yeditepe.eventhandler.dto.PaymentResponse;

import java.util.List;
import java.util.UUID;

public interface PaymentService {

    PaymentResponse create(PaymentRequest request);

    PaymentResponse getById(UUID paymentId);

    List<PaymentResponse> getByUserId(UUID userId);

    List<PaymentResponse> getByBookingId(UUID bookingId);
}
