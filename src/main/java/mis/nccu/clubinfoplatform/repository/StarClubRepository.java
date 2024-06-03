package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.StarClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarClubRepository extends JpaRepository<StarClub, Long> {
    List<StarClub> findByUserIdAndClubId(Long userId, Long clubId);

}
