package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class DigitalKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RoomBooking booking;

    @Column(unique = true)
    private String keyValue;

    private Instant issuedAt;
    private Instant expiresAt;
    private Boolean active;

    // getters & setters
}
