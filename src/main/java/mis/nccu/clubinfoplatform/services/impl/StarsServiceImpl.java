package mis.nccu.clubinfoplatform.services.impl;

import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.repository.FollowsRepository;
import mis.nccu.clubinfoplatform.services.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StarsServiceImpl implements FollowsService {
    @Autowired
    FollowsRepository followsRepository;

    @Override
    public List<Follows> getByClubId(Long clubId) {
        return followsRepository.findByClubId(clubId);
    }

    @Override
    public Follows getById(Long id) {
        return followsRepository.findById(id).orElseThrow(() -> new RuntimeException("找不到追蹤" + id));
    }

    @Override
    public void saveOrUpdate(Follows follows) {
        followsRepository.save(follows);
    }

}

