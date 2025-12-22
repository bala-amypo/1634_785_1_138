package com.example.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/access-logs")
@Tag(name = "Access Logs")
public class AccessLogController {

    @PostMapping
    public ResponseEntity<?> createLog(@RequestBody Object request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/key/{keyId}")
    public ResponseEntity<?> getLogsByKey(@PathVariable Long keyId) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/guest/{guestId}")
    public ResponseEntity<?> getLogsByGuest(@PathVariable Long guestId) {
        return ResponseEntity.ok().build();
    }
}
