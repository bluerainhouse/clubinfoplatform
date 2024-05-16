package mis.nccu.clubinfoplatform.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mis.nccu.clubinfoplatform.models.Manages;
import mis.nccu.clubinfoplatform.models.ids.ManagesId;

@Repository
public interface ManagesRepository extends JpaRepository<Manages, ManagesId> {

}
