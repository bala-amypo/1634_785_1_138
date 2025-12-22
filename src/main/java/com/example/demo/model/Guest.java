package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String fullName;
    private String phoneNumber;
    private Boolean verified;
    private Boolean active = true;
    private String role;
    private Instant createdAt;

    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
    }

    // getters & setters
}
