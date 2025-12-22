package com.example.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@Tag(name = "Room Bookings")
public class RoomBookingController {

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooking(
            @PathVariable Long id,
            @RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBooking(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/guest/{guestId}")
    public ResponseEntity<?> listBookingsForGuest(@PathVariable Long guestId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivateBooking(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
