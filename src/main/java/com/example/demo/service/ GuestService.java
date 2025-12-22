package com.example.demo.service;

import com.example.demo.model.Guest;
import java.util.List;

interface GuestService {
    Guest createGuest(Guest guest);
    Guest updateGuest(Long id, Guest guest);
    Guest getGuestById(Long id);
    List<Guest> getAllGuests();
    void deactivateGuest(Long id);
}
