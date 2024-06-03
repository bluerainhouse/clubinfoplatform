package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.payload.request.FollowRequest;

import java.util.List;

public interface FollowsService {
    List<Follows> getByUserId(Long userId);

    Follows getById(Long id);

    void update(Long id, FollowRequest followRequest);

    void save(FollowRequest followRequest);


}

