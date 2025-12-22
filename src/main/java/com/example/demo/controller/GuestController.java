package com.example.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guests")
@Tag(name = "Guests")
public class GuestController {

    @PostMapping
    public ResponseEntity<?> createGuest(@RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGuest(
            @PathVariable Long id,
            @RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGuest(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> listGuests() {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivateGuest(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
