package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "key_share_requests")
public class KeyShareRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "digital_key_id")
    private DigitalKey digitalKey;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shared_by")
    private Guest sharedBy;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shared_with")
    private Guest sharedWith;

    private LocalDateTime shareStart;

    private LocalDateTime shareEnd;

    private String status;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public DigitalKey getDigitalKey() {
        return digitalKey;
    }

    public Guest getSharedBy() {
        return sharedBy;
    }

    public Guest getSharedWith() {
        return sharedWith;
    }

    public LocalDateTime getShareStart() {
        return shareStart;
    }

    public LocalDateTime getShareEnd() {
        return shareEnd;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void SetId(Long id) {
        this.id=id;
    }
    public void setDigitalKey(DigitalKey digitalKey) {
        this.digitalKey = digitalKey;
    }

    public void setSharedBy(Guest sharedBy) {
        this.sharedBy = sharedBy;
    }

    public void setSharedWith(Guest sharedWith) {
        this.sharedWith = sharedWith;
    }

    public void setShareStart(LocalDateTime shareStart) {
        this.shareStart = shareStart;
    }

    public void setShareEnd(LocalDateTime shareEnd) {
        this.shareEnd = shareEnd;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
