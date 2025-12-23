package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomBookingService {

    List<Room> getAvailableRooms();

    Booking bookRoom(Long roomId,
                     String customerName,
                     LocalDate checkInDate,
                     LocalDate checkOutDate);

    void cancelBooking(Long bookingId);
}
