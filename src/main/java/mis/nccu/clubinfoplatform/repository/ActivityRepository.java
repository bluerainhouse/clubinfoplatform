package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
