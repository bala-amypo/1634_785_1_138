import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.demo.model.DigitalKey;
import com.example.demo.model.RoomBooking;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DigitalKeyRepository;
import com.example.demo.repository.RoomBookingRepository;
import com.example.demo.service.DigitalKeyService;

@Service
@RequiredArgsConstructor
public class DigitalKeyServiceImpl implements DigitalKeyService {

    public final DigitalKeyRepository keyRepository;
    public final RoomBookingRepository bookingRepository;

    @Override
    public DigitalKey generateKey(Long bookingId) {
        RoomBooking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        if (!booking.isActive()) {
            throw new IllegalStateException("Booking is inactive");
        }

        DigitalKey key = new DigitalKey();
        key.setBooking(booking);
        key.setActive(true);
        key.setGeneratedAt(LocalDateTime.now());
        return keyRepository.save(key);
    }

    @Override
    public DigitalKey getKeyById(Long id) {
        return keyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Key not found"));
    }

    @Override
    public DigitalKey getActiveKeyForBooking(Long bookingId) {
        return keyRepository.findByBookingIdAndActiveTrue(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Active key not found"));
    }

    @Override
    public List<DigitalKey> getKeysForGuest(Long guestId) {
        return keyRepository.findByGuestId(guestId);
    }
}
