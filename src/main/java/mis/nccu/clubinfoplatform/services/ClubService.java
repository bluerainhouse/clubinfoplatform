package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.Club;
import mis.nccu.clubinfoplatform.models.vo.ClubData;
import mis.nccu.clubinfoplatform.payload.request.ClubUpdateRequest;
import mis.nccu.clubinfoplatform.payload.response.ClubDetailResponse;

import java.util.List;

public interface ClubService {

    void updateClubDetail(ClubUpdateRequest clubUpdateRequest);

    List<Club> getStarClubs(Long userId);

    ClubDetailResponse getClubDetail(Long clubId);
    List<Club> getAllClubs();
}

