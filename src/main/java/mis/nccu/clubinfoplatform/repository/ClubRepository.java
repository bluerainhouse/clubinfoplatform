package mis.nccu.clubinfoplatform.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import mis.nccu.clubinfoplatform.models.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> findByIdIn(List<Long> id);
}
