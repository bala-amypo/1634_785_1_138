package com.example.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/digital-keys")
@Tag(name = "Digital Keys")
public class DigitalKeyController {
    
DigitalKey key = keyRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Key not found"));

    @PostMapping("/generate/{bookingId}")
    public ResponseEntity<?> generateKey(@PathVariable Long bookingId) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKey(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<?> getActiveKeyForBooking(@PathVariable Long bookingId) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/guest/{guestId}")
    public ResponseEntity<?> listKeysForGuest(@PathVariable Long guestId) {
        return ResponseEntity.ok().build();
    }
}
