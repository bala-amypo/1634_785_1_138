package com.example.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/key-share")
@Tag(name = "Key Share Requests")
public class KeyShareRequestController {

    @PostMapping
    public ResponseEntity<?> createRequest(@RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRequest(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/shared-by/{guestId}")
    public ResponseEntity<?> sharedBy(@PathVariable Long guestId) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/shared-with/{guestId}")
    public ResponseEntity<?> sharedWith(@PathVariable Long guestId) {
        return ResponseEntity.ok().build();
    }
}
