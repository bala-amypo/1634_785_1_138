package com.example.demo.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.demo.model.RoomBooking;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RoomBookingRepository;
import com.example.demo.service.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@RequiredArgsConstructor
public class RoomBookingServiceImpl implements RoomBookingService {

    @Autowired RoomBookingRepository bookingRepository;

    @Override
    public RoomBooking createBooking(RoomBooking booking) {
        if (booking.getCheckOutDate().isBefore(booking.getCheckInDate())) {
            throw new IllegalArgumentException("Invalid booking dates");
        }
        booking.setActive(true);
        return bookingRepository.save(booking);
    }

    @Override
    public RoomBooking updateBooking(Long id, RoomBooking booking) {
        RoomBooking existing = getBookingById(id);
        existing.setCheckInDate(booking.getCheckInDate());
        existing.setCheckOutDate(booking.getCheckOutDate());
        return bookingRepository.save(existing);
    }

    @Override
    public RoomBooking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
    }

    @Override
    public List<RoomBooking> getBookingsForGuest(Long guestId) {
        return bookingRepository.findByGuestId(guestId);
    }

    @Override
    public void deactivateBooking(Long id) {
        RoomBooking booking = getBookingById(id);
        booking.setActive(false);
        bookingRepository.save(booking);
    }
}
