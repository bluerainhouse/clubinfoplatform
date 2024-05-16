package mis.nccu.clubinfoplatform.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mis.nccu.clubinfoplatform.models.Joins;
import mis.nccu.clubinfoplatform.models.ids.JoinsId;

@Repository
public interface JoinsRepository extends JpaRepository<Joins, JoinsId> {

}
