package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.demo.model.KeyShareRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.KeyShareRequestRepository;
import com.example.demo.service.KeyShareRequestService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@RequiredArgsConstructor
public class KeyShareRequestServiceImpl implements KeyShareRequestService {

    @Autowired KeyShareRequestRepository requestRepository;

    @Override
    public KeyShareRequest createShareRequest(KeyShareRequest request) {
        if (request.getEndDate().isBefore(request.getStartDate())) {
            throw new IllegalArgumentException("Invalid share dates");
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
                .orElseThrow(() -> new ResourceNotFoundException("Share request not found"));
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
