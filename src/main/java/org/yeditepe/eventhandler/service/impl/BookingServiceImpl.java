package org.yeditepe.eventhandler.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yeditepe.eventhandler.dto.BookingRequest;
import org.yeditepe.eventhandler.dto.BookingResponse;
import org.yeditepe.eventhandler.model.Booking;
import org.yeditepe.eventhandler.model.BookingStatus;
import org.yeditepe.eventhandler.repository.BookingRepository;
import org.yeditepe.eventhandler.service.BookingService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingResponse create(BookingRequest request) {
        if (request.getTicketCount() <= 0) {
            throw new IllegalArgumentException("ticketCount must be bigger than 0");
        }

        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setEventId(request.getEventId());
        booking.setTicketCount(request.getTicketCount());

        // Default Values
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setPaymentCompleted(false);

        Booking saved = bookingRepository.save(booking);
        return toResponse(saved);
    }

    @Override
    public BookingResponse getById(UUID bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found: " + bookingId));

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
    public BookingResponse cancel(UUID bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found: " + bookingId));

        booking.setStatus(BookingStatus.CANCELLED);
        Booking updated = bookingRepository.save(booking);

        return toResponse(updated);
    }

    // Mapping Method Entity -> DTO
    private BookingResponse toResponse(Booking booking) {
        BookingResponse response = new BookingResponse();
        response.setId(booking.getId());
        response.setUserId(booking.getUserId());
        response.setEventId(booking.getEventId());
        response.setTicketCount(booking.getTicketCount());
        response.setStatus(booking.getStatus().name());
        response.setPaymentCompleted(booking.isPaymentCompleted());
        response.setBookingDate(booking.getBookingDate());
        return response;
    }
}
