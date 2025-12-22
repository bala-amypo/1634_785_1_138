package com.example.demo.service.Impl;

import lombok.RequiredArgsConstructor;

import com.example.demo.model.Guest;
import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import com.example.demo.service.GuestService;
import com.example.demo.repository.GuestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository repo;

    public GuestServiceImpl(GuestRepository repo) {
        this.repo = repo;
    }

    public Guest createGuest(Guest guest) {
        return repo.save(guest);
    }

    public Guest updateGuest(Long id, Guest guest) {
        guest.setId(id);
        return repo.save(guest);
    }

    public Guest getGuestById(Long id) {
        return repo.findById(id).orElseThrow(null);
    }

    public List<Guest> getAllGuests() {
        return repo.findAll();
    }

    public void deactivateGuest(Long id) {
        Guest g = getGuestById(id);
        g.setActive(false);
        repo.save(g);
    }
}
