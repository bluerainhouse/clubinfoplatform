package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
