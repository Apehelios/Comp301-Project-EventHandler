package org.yeditepe.eventhandler.service;

import org.yeditepe.eventhandler.dto.BookingRequest;
import org.yeditepe.eventhandler.dto.BookingResponse;

import java.util.List;
import java.util.UUID;

public interface BookingService {

    BookingResponse create(BookingRequest request);

    BookingResponse getById(UUID bookingId);

    List<BookingResponse> getByUserId(UUID userId);

    BookingResponse cancel(UUID bookingId);
}
