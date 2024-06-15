package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.payload.request.FollowRequest;

import java.util.List;

public interface FollowsService {
    List<Follows> getByUserId(Long userId);

    Follows getByUserIdAndActivityId(Long userId, Long activityId);

    void update(Long id, FollowRequest followRequest);

    Follows save(FollowRequest followRequest);

    void delete(Long id);
}

