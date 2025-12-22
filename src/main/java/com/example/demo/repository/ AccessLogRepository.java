package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AccessLog;
import org.springframework.data.stereotype.Repository;

import java.util.List;

@Repository
interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
    List<AccessLog> findByGuestId(Long guestId);
    List<AccessLog> findByDigitalKeyId(Long keyId);
}
