public interface DigitalKeyService {

    DigitalKey generateKey(Long bookingId);

    DigitalKey getKeyById(Long id);

    DigitalKey getActiveKeyForBooking(Long bookingId);

    List<DigitalKey> getKeysForGuest(Long guestId);
}
