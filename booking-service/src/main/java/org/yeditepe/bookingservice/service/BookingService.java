package org.yeditepe.bookingservice.service;

import org.yeditepe.bookingservice.dto.BookingRequest;
import org.yeditepe.bookingservice.dto.BookingResponse;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    BookingResponse create(BookingRequest request);
    BookingResponse getById(UUID id);
    List<BookingResponse> getByUserId(UUID userId);
    BookingResponse cancel(UUID id);
}
