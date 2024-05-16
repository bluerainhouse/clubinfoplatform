package mis.nccu.clubinfoplatform.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mis.nccu.clubinfoplatform.models.ClubManager;

@Repository
public interface ClubManagerRepository extends JpaRepository<ClubManager, Long> {

}
