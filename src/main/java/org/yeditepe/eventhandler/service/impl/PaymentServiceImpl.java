package org.yeditepe.eventhandler.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yeditepe.eventhandler.dto.PaymentRequest;
import org.yeditepe.eventhandler.dto.PaymentResponse;
import org.yeditepe.eventhandler.model.Payment;
import org.yeditepe.eventhandler.model.PaymentStatus;
import org.yeditepe.eventhandler.repository.PaymentRepository;
import org.yeditepe.eventhandler.service.PaymentService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentResponse create(PaymentRequest request) {
        if (request.getAmount() <= 0) {
            throw new IllegalArgumentException("amount must be bigger than 0");
        }

        Payment payment = new Payment();
        payment.setBookingId(request.getBookingId());
        payment.setUserId(request.getUserId());
        payment.setAmount(request.getAmount());

        // Now  we simulate a successful payment
        payment.setStatus(PaymentStatus.SUCCESS);

        Payment saved = paymentRepository.save(payment);
        return toResponse(saved);
    }

    @Override
    public PaymentResponse getById(UUID paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("Payment not found: " + paymentId));

        return toResponse(payment);
    }

    @Override
    public List<PaymentResponse> getByUserId(UUID userId) {
        return paymentRepository.findByUserId(userId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponse> getByBookingId(UUID bookingId) {
        return paymentRepository.findByBookingId(bookingId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private PaymentResponse toResponse(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setId(payment.getId());
        response.setBookingId(payment.getBookingId());
        response.setUserId(payment.getUserId());
        response.setAmount(payment.getAmount());
        response.setStatus(payment.getStatus().name());
        response.setCreatedAt(payment.getCreatedAt());
        return response;
    }
}
