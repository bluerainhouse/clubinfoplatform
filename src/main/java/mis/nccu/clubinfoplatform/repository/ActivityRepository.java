package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByClubIdAndType(Long id, String type);

    List<Activity> findByIdIn(List<Long> id);

    Activity findFirstByClubIdAndTypeOrderByStartDateDesc(Long clubIdm, String type);


}
