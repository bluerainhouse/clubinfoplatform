package mis.nccu.clubinfoplatform.services.impl;

import mis.nccu.clubinfoplatform.models.Announcement;
import mis.nccu.clubinfoplatform.models.Club;
import mis.nccu.clubinfoplatform.models.StarClub;
import mis.nccu.clubinfoplatform.models.Stars;
import mis.nccu.clubinfoplatform.payload.request.AnoPostRequest;
import mis.nccu.clubinfoplatform.payload.request.AnoPutRequest;
import mis.nccu.clubinfoplatform.repository.AnnouncementRepository;
import mis.nccu.clubinfoplatform.repository.ClubRepository;
import mis.nccu.clubinfoplatform.repository.StarClubRepository;
import mis.nccu.clubinfoplatform.repository.StarsRepository;
import mis.nccu.clubinfoplatform.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    AnnouncementRepository announcementRepository;

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    StarsRepository starsRepository;

    @Autowired
    StarClubRepository starClubRepository;

    @Override
    public List<Announcement> getAll() {
        return announcementRepository.findAllByOrderByDateDesc();
    }

    @Override
    public List<Announcement> getByUserId(Long userId) {
        List<Long> anoIds = starsRepository.findByUserId(userId).stream().map(Stars::getAnoId).collect(Collectors.toList());
        return announcementRepository.findByIdIn(anoIds);
    }

    @Override
    public List<Announcement> getByClubIds(Long userId) {
        List<Long> clubIds = starClubRepository.findByUserId(userId).stream().map(StarClub::getClubId).collect(Collectors.toList());
        return announcementRepository.findByClubIdInOrderByDateDesc(clubIds);
    }

    @Override
    public void save(AnoPostRequest anoPostRequest) {
        Club club = clubRepository.findById(anoPostRequest.getClubId()).orElseThrow(() -> new RuntimeException("No Club Found!"));
        announcementRepository.save(new Announcement(club.getId(), club.getClubName(),
                anoPostRequest.getTitle(), anoPostRequest.getContent(), anoPostRequest.getDate()));
    }

    @Override
    public void update(Long id, AnoPutRequest anoPutRequest) {
        Announcement announcement = announcementRepository.findById(id).orElseThrow(() -> new RuntimeException("No Ano Found!"));
        announcement.setTitle(anoPutRequest.getTitle());
        announcement.setContent(anoPutRequest.getContent());
        announcement.setDate(anoPutRequest.getDate());
        announcementRepository.save(announcement);
    }

    @Override
    public void delete(Long id) {
        announcementRepository.deleteById(id);
    }
}

