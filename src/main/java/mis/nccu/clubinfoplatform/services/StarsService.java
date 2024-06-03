package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.models.Stars;
import mis.nccu.clubinfoplatform.payload.request.StarRequest;

import java.util.List;

public interface StarsService {
    List<Stars> getByUserIdAndAnoId(Long userId, Long anoId);

    void save(StarRequest starRequest);

    void delete(Long id);


}

