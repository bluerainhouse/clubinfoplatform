package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.Stars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarsRepository extends JpaRepository<Stars, Long> {
    Stars findFirstByUserIdAndAnoId(Long userId, Long anoId);

    List<Stars> findByUserId(Long userId);
}
