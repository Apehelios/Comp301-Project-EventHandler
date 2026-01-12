package org.yeditepe.bookingservice.service.impl;

import org.springframework.stereotype.Service;
import org.yeditepe.bookingservice.dto.BookingRequest;
import org.yeditepe.bookingservice.dto.BookingResponse;
import org.yeditepe.bookingservice.model.Booking;
import org.yeditepe.bookingservice.model.BookingStatus;
import org.yeditepe.bookingservice.repository.BookingRepository;
import org.yeditepe.bookingservice.service.BookingService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    private BookingResponse toResponse(Booking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getUserId(),
                booking.getEventId(),
                booking.getSeatCount(),
                booking.getStatus(),
                booking.getCreatedAt()
        );
    }

    @Override
    public BookingResponse create(BookingRequest request) {
        Booking booking = new Booking(
                request.getUserId(),
                request.getEventId(),
                request.getSeatCount()
        );

        Booking saved = bookingRepository.save(booking);
        return toResponse(saved);
    }

    @Override
    public BookingResponse getById(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return toResponse(booking);
    }

    @Override
    public List<BookingResponse> getByUserId(UUID userId) {
        return bookingRepository.findByUserId(userId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponse cancel(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELLED);
        return toResponse(bookingRepository.save(booking));
    }
}
