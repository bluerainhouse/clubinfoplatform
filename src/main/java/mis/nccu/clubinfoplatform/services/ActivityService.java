package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.Activity;
import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.payload.request.ActPostRequest;
import mis.nccu.clubinfoplatform.payload.request.ActPutRequest;
import mis.nccu.clubinfoplatform.payload.request.AnoPostRequest;
import mis.nccu.clubinfoplatform.payload.request.AnoPutRequest;
import mis.nccu.clubinfoplatform.payload.response.ActAllResponse;
import mis.nccu.clubinfoplatform.payload.response.ActOneResponse;

import java.util.List;

public interface ActivityService {
    List<ActAllResponse> getByType(String type);

    List<ActAllResponse> getAll();

    ActOneResponse geyById(Long actId);

    List<Activity> getByActIds(Long userId);

    Activity getNewewstActivity(Long clubId, String type);

    void save(ActPostRequest actPostRequest);

    void update(Long id, ActPutRequest actPutRequest);

    void delete(Long id);
}

