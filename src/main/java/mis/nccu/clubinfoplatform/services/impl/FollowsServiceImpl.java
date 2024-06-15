package mis.nccu.clubinfoplatform.services.impl;

import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.payload.request.FollowRequest;
import mis.nccu.clubinfoplatform.repository.FollowsRepository;
import mis.nccu.clubinfoplatform.services.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FollowsServiceImpl implements FollowsService {
    @Autowired
    FollowsRepository followsRepository;

    @Override
    public List<Follows> getByUserId(Long userId) {
        return followsRepository.findByUserId(userId);
    }

    @Override
    public Follows getByUserIdAndActivityId(Long userId, Long activityId) {
        return followsRepository.findFirstByUserIdAndActivityId(userId, activityId);
    }

    @Override
    public void update(Long id, FollowRequest followRequest) {
        Follows follows = followsRepository.findById(id).orElseThrow(() -> new RuntimeException("找不到追蹤" + id));
        follows.setActivityId(followRequest.getActivityId());
        follows.setUserId(followRequest.getUserId());
        followsRepository.save(follows);
    }

    @Override
    public Follows save(FollowRequest followRequest) {
        return followsRepository.save(new Follows(followRequest.getUserId(), followRequest.getActivityId()));
    }

    @Override
    public void delete(Long id) {
        Follows follows = followsRepository.findById(id).orElseThrow(() -> new RuntimeException("找不到追蹤" + id));
        followsRepository.delete(follows);
    }

}

