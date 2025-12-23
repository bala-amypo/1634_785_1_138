package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "access_logs")
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "digital_key_id")
    private DigitalKey digitalKey;

    @ManyToOne(optional = false)
    @JoinColumn(name = "guest_id")
    private Guest guest;

    private LocalDateTime accessTime;

    private String result;

    private String reason;

    public Long getId() {
        return id;
    }

    public DigitalKey getDigitalKey() {
        return digitalKey;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDateTime getAccessTime() {
        return accessTime;
    }

    public String getResult() {
        return result;
    }

    public String getReason() {
        return reason;
    }

    public void setDigitalKey(DigitalKey digitalKey) {
        this.digitalKey = digitalKey;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setAccessTime(LocalDateTime accessTime) {
        this.accessTime = accessTime;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
