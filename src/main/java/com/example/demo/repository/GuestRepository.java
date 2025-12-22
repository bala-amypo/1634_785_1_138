package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Guest;
import org.springframework.data.stereotype.Repository;


@Repository
 public interface GuestRepository extends JpaRepository<Guest, Long> {
}
the error is [ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/GuestRepository.java:[5,43] package org.springframework.data.stereotype does not exist