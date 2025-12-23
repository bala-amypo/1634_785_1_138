package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.KeyShareRequest;
import com.example.demo.repository.KeyShareRequestRepository;
import com.example.demo.service.KeyShareRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyShareRequestServiceImpl implements KeyShareRequestService {

    KeyShareRequestRepository requestRepository;

    @Autowired
    public KeyShareRequestServiceImpl(KeyShareRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public KeyShareRequest createShareRequest(KeyShareRequest request) {
        if (request.getShareStart().isAfter(request.getShareEnd())) {
            throw new IllegalArgumentException("Invalid share dates");
        }
        if (request.getSharedBy().getId()
                .equals(request.getSharedWith().getId())) {
            throw new IllegalArgumentException("Cannot share with same user");
        }
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }

    @Override
    public KeyShareRequest updateStatus(Long requestId, String status) {
        KeyShareRequest request = getShareRequestById(requestId);
        request.setStatus(status);
        return requestRepository.save(request);
    }

    @Override
    public KeyShareRequest getShareRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
    }

    @Override
    public List<KeyShareRequest> getRequestsSharedBy(Long guestId) {
        return requestRepository.findBySharedById(guestId);
    }

    @Override
    public List<KeyShareRequest> getRequestsSharedWith(Long guestId) {
        return requestRepository.findBySharedWithId(guestId);
    }
}
