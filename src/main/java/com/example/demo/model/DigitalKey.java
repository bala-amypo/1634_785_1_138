package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "digital_keys")
public class DigitalKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "booking_id")
    private RoomBooking booking;

    @Column(unique = true, nullable = false)
    private String keyValue;

    private LocalDateTime issuedAt;

    private LocalDateTime expiresAt;

    private Boolean active;

    public Long getId() {
        return id;
    }

    public RoomBooking getBooking() {
        return booking;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public Boolean isActive() {
        return active;
    }

    public void setBooking(RoomBooking booking) {
        this.booking = booking;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
