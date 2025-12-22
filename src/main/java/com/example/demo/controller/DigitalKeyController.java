package com.example.api.controller;

import com.example.demo.model.DigitalKey;
import com.example.demo.service.DigitalKeyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/digital-keys")
@Tag(name = "Digital Keys")
public class DigitalKeyController {

    private final DigitalKeyService digitalKeyService;

    public DigitalKeyController(DigitalKeyService digitalKeyService) {
        this.digitalKeyService = digitalKeyService;
    }

    @PostMapping("/generate/{bookingId}")
    public ResponseEntity<DigitalKey> generateKey(@PathVariable Long bookingId) {
        DigitalKey key = digitalKeyService.generateKey(bookingId);
        return ResponseEntity.ok(key);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigitalKey> getKey(@PathVariable Long id) {
        DigitalKey key = digitalKeyService.getKeyById(id);
        return ResponseEntity.ok(key);
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<DigitalKey> getActiveKeyForBooking(@PathVariable Long bookingId) {
        DigitalKey key = digitalKeyService.getActiveKeyForBooking(bookingId);
        return ResponseEntity.ok(key);
    }

    @GetMapping("/guest/{guestId}")
    public ResponseEntity<List<DigitalKey>> listKeysForGuest(@PathVariable Long guestId) {
        List<DigitalKey> keys = digitalKeyService.getKeysForGuest(guestId);
        return ResponseEntity.ok(keys);
    }
}
