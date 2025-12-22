@Service
@RequiredArgsConstructor
public class AccessLogServiceImpl implements AccessLogService {

    private final AccessLogRepository logRepository;
    private final DigitalKeyRepository keyRepository;

    @Override
    public AccessLog createLog(AccessLog log) {
        DigitalKey key = keyRepository.findById(log.getKey().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Key not found"));

        log.setTimestamp(LocalDateTime.now());
        log.setResult(key.isActive() ? "SUCCESS" : "DENIED");

        return logRepository.save(log);
    }

    @Override
    public List<AccessLog> getLogsForKey(Long keyId) {
        return logRepository.findByKeyId(keyId);
    }

    @Override
    public List<AccessLog> getLogsForGuest(Long guestId) {
        return logRepository.findByGuestId(guestId);
    }
}
