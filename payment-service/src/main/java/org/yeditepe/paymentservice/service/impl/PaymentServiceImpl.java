package org.yeditepe.paymentservice.service.impl;

import org.springframework.stereotype.Service;
import org.yeditepe.paymentservice.dto.PaymentRequest;
import org.yeditepe.paymentservice.dto.PaymentResponse;
import org.yeditepe.paymentservice.model.Payment;
import org.yeditepe.paymentservice.model.PaymentStatus;
import org.yeditepe.paymentservice.repository.PaymentRepository;
import org.yeditepe.paymentservice.service.PaymentService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    private PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getBookingId(),
                payment.getAmount(),
                payment.getStatus(),
                payment.getCreatedAt()
        );
    }

    @Override
    public PaymentResponse create(PaymentRequest request) {
        Payment payment = new Payment(
                request.getBookingId(),
                request.getAmount()
        );

        Payment saved = paymentRepository.save(payment);

        // simple simulation logic
        if (saved.getAmount() > 10_000) {
            saved.setStatus(PaymentStatus.FAILED);
        } else {
            saved.setStatus(PaymentStatus.COMPLETED);
        }

        return toResponse(paymentRepository.save(saved));
    }

    @Override
    public PaymentResponse getById(UUID id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return toResponse(payment);
    }

    @Override
    public List<PaymentResponse> getByBookingId(UUID bookingId) {
        return paymentRepository.findByBookingId(bookingId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponse complete(UUID id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus(PaymentStatus.COMPLETED);
        return toResponse(paymentRepository.save(payment));
    }

    @Override
    public PaymentResponse fail(UUID id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus(PaymentStatus.FAILED);
        return toResponse(paymentRepository.save(payment));
    }
}
