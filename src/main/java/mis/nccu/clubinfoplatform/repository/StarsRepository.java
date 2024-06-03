package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.Stars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarsRepository extends JpaRepository<Stars, Long> {
    List<Stars> findByUserIdAndAnoId(Long userId, Long anoId);
}
