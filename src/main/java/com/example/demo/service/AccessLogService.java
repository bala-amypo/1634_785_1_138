import java.util.List;

import com.example.demo.model.AccessLog;

public interface AccessLogService {

    AccessLog createLog(AccessLog log);

    List<AccessLog> getLogsForKey(Long keyId);

    List<AccessLog> getLogsForGuest(Long guestId);
}
