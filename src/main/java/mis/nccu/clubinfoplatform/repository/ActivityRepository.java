package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByType(String type);

    List<Activity> findByIdIn(List<Long> id);

    Activity findFirstByClubIdAndTypeOrderByStartDateDesc(Long clubId, String type);


}
