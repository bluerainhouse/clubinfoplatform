package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.StarClub;
import mis.nccu.clubinfoplatform.payload.request.StarClubRequest;

import java.util.List;

public interface StarClubService {
    StarClub getByUserIdAndClubId(Long userId, Long clubId);

    List<StarClub> getByUserId(Long userId);

    StarClub save(StarClubRequest starClubRequest);

    void delete(Long id);
}

