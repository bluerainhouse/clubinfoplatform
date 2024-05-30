package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.Joins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinsRepository extends JpaRepository<Joins, Long> {

}
