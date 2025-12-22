package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Guest;
import org.springframework.data.stereotype.Repository;


@Repository
 public interface GuestRepository extends JpaRepository<Guest, Long> {
}
