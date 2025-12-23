package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomBookingService {

    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    public RoomBookingService(RoomRepository roomRepository,
                              BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailableTrue();
    }

    public Booking bookRoom(Long roomId, String customerName,
                            LocalDate checkIn, LocalDate checkOut) {

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        if (!room.isAvailable()) {
            throw new RuntimeException("Room already booked");
        }

        room.setAvailable(false);
        roomRepository.save(room);

        Booking booking = new Booking(room, customerName, checkIn, checkOut);
        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        Room room = booking.getRoom();
        room.setAvailable(true);
        roomRepository.save(room);

        bookingRepository.delete(booking);
    }
}
