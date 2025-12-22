import java.util.List;

import com.example.demo.entity.KeyShareRequest;
public interface KeyShareRequestService {

    KeyShareRequest createShareRequest(KeyShareRequest request);

    KeyShareRequest updateStatus(Long requestId, String status);

    KeyShareRequest getShareRequestById(Long id);

    List<KeyShareRequest> getRequestsSharedBy(Long guestId);

    List<KeyShareRequest> getRequestsSharedWith(Long guestId);
}
