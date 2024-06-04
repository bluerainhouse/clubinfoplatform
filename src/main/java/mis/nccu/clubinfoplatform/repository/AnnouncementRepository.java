package mis.nccu.clubinfoplatform.repository;

import mis.nccu.clubinfoplatform.models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findAllByOrderByDateDesc();

    List<Announcement> findByIdIn(List<Long> id);

    List<Announcement> findByClubIdInOrderByDateDesc(List<Long> clubId);
}
