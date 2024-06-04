package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.Follows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowsRepository extends JpaRepository<Follows, Long> {
    List<Follows> findByUserId(Long userId);
    Follows findFirstByUserIdAndActivityId(Long userId, Long activityId);
}
