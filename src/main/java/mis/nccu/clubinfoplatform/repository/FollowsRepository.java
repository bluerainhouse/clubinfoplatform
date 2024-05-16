package mis.nccu.clubinfoplatform.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.models.ids.FollowsId;

@Repository
public interface FollowsRepository extends JpaRepository<Follows, FollowsId> {

}
