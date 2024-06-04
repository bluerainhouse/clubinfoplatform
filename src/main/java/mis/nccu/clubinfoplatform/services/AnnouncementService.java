package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.Announcement;
import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.payload.request.AnoPostRequest;
import mis.nccu.clubinfoplatform.payload.request.AnoPutRequest;
import mis.nccu.clubinfoplatform.payload.response.AnoAllResponse;
import mis.nccu.clubinfoplatform.payload.response.AnoOneResponse;

import java.util.List;

public interface AnnouncementService {
    List<AnoAllResponse> getAll();

    AnoOneResponse getById(Long id);

    List<AnoAllResponse> getByUserId(Long userId);

    List<AnoAllResponse> getByClubIds(Long userId);

    void save(AnoPostRequest anoPostRequest);

    void update(Long id, AnoPutRequest anoPutRequest);

    void delete(Long id);
}

