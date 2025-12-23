package com.example.demo.service.impl;

import com.example.demo.model.AccessLog;
import com.example.demo.model.DigitalKey;
import com.example.demo.repository.AccessLogRepository;
import com.example.demo.repository.DigitalKeyRepository;
import com.example.demo.service.AccessLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccessLogServiceImpl implements AccessLogService {

    AccessLogRepository logRepository;
    DigitalKeyRepository keyRepository;

    @Autowired
    public AccessLogServiceImpl(AccessLogRepository logRepository,
                                DigitalKeyRepository keyRepository) {
        this.logRepository = logRepository;
        this.keyRepository = keyRepository;
    }

    @Override
    public AccessLog createLog(AccessLog log) {
        DigitalKey key = keyRepository.findById(log.getDigitalKey().getId())
                .orElse(null);

        log.setAccessTime(LocalDateTime.now());

        if (key != null && key.isActive()) {
            log.setResult("SUCCESS");
        } else {
            log.setResult("DENIED");
            log.setReason("Invalid or inactive key");
        }
        return logRepository.save(log);
    }

    @Override
    public List<AccessLog> getLogsForKey(Long keyId) {
        return logRepository.findByDigitalKeyId(keyId);
    }

    @Override
    public List<AccessLog> getLogsForGuest(Long guestId) {
        return logRepository.findByGuestId(guestId);
    }
}
