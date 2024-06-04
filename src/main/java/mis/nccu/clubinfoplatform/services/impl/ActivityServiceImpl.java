package mis.nccu.clubinfoplatform.services.impl;

import mis.nccu.clubinfoplatform.models.Activity;
import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.payload.request.ActPostRequest;
import mis.nccu.clubinfoplatform.payload.request.ActPutRequest;
import mis.nccu.clubinfoplatform.repository.ActivityRepository;
import mis.nccu.clubinfoplatform.repository.FollowsRepository;
import mis.nccu.clubinfoplatform.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    FollowsRepository followsRepository;

    @Override
    public List<Activity> getByClubIdAndType(Long id, String type) {
        return activityRepository.findByClubIdAndType(id, type);
    }

    @Override
    public Activity geyById(Long actId) {
        return activityRepository.findById(actId).orElseThrow(() -> new RuntimeException("No Act Found!"));
    }

    @Override
    public List<Activity> getByActIds(Long userId) {
       List<Long> activityIds = followsRepository.findByUserId(userId).stream().map(Follows::getActivityId).collect(Collectors.toList());
        return activityRepository.findByIdIn(activityIds);
    }

    @Override
    public Activity getNewewstActivity(Long clubId, String type) {
        return activityRepository.findFirstByClubIdAndTypeOrderByStartDateDesc(clubId, type);
    }

    @Override
    public void save(ActPostRequest actPostRequest) {
        activityRepository.save(new Activity(actPostRequest.getClubId(), actPostRequest.getStartDate(), actPostRequest.getStartTime(),
                actPostRequest.getEndDate(), actPostRequest.getEndTime(), actPostRequest.getTitle(), actPostRequest.getDetail(),
                actPostRequest.getType(), actPostRequest.getFee()));
    }

    @Override
    public void update(Long id, ActPutRequest actPutRequest) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("No Act Found!"));
        activity.setStartDate(actPutRequest.getStartDate());
        activity.setStartTime(actPutRequest.getStartTime());
        activity.setEndDate(actPutRequest.getEndDate());
        activity.setEndTime(actPutRequest.getEndTime());
        activity.setTitle(actPutRequest.getTitle());
        activity.setDetail(actPutRequest.getDetail());
        activity.setFee(actPutRequest.getFee());
        activityRepository.save(activity);
    }

    @Override
    public void delete(Long id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("No Act Found!"));
        activityRepository.delete(activity);
    }
}

