package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DigitalKey;
import java.util.List;

@Repository
public interface DigitalKeyRepository extends JpaRepository<DigitalKey, Long> {
    DigitalKey findByBookingIdAndActiveTrue(Long bookingId);
    List<DigitalKey> findByBookingGuestId(Long guestId);
}
