package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.Follows;

import java.util.List;

public interface FollowsService {
    List<Follows> getByClubId(Long id);

    Follows getById(Long id);

    void saveOrUpdate(Follows follows);


}

