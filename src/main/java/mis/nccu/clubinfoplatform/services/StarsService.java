package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.Follows;

import java.util.List;

public interface StarsService {
    List<Follows> getByClubId(Long id);

    Follows getById(Long id);

    void saveOrUpdate(Follows follows);


}

