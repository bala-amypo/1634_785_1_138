package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomBookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    public RoomBookingServiceImpl(RoomRepository roomRepository,
                                  BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailableTrue();
    }

    @Override
    public Booking bookRoom(Long roomId,
                            String customerName,
                            LocalDate checkInDate,
                            LocalDate checkOutDate) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Room not found with id: " + roomId));

        if (!room.isAvailable()) {
            throw new RuntimeException("Room is already booked");
        }

        room.setAvailable(false);
        roomRepository.save(room);

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setCustomerName(customerName);
        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);

        return bookingRepository.save(booking);
    }

    @Override
    public void cancelBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Booking not found with id: " + bookingId));

        Room room = booking.getRoom();
        room.setAvailable(true);
        roomRepository.save(room);

        bookingRepository.delete(booking);
    }
}
