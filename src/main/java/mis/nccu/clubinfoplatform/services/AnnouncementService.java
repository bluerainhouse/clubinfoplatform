package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.Announcement;
import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.payload.request.AnoPostRequest;
import mis.nccu.clubinfoplatform.payload.request.AnoPutRequest;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> getAll();

    List<Announcement> getByUserId(Long userId);

    List<Announcement> getByClubIds(Long userId);

    void save(AnoPostRequest anoPostRequest);

    void update(Long id, AnoPutRequest anoPutRequest);

    void delete(Long id);
}

