package mis.nccu.clubinfoplatform.services.impl;

import mis.nccu.clubinfoplatform.models.*;
import mis.nccu.clubinfoplatform.payload.request.AnoPostRequest;
import mis.nccu.clubinfoplatform.payload.request.AnoPutRequest;
import mis.nccu.clubinfoplatform.payload.response.AnoAllResponse;
import mis.nccu.clubinfoplatform.payload.response.AnoOneResponse;
import mis.nccu.clubinfoplatform.repository.*;
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

    @Autowired
    UserRepository userRepository;

    @Override
    public List<AnoAllResponse> getAll() {
        List<Announcement> announcements = announcementRepository.findAllByOrderByDateDesc();
        return announcements.stream().map(announcement -> {
            String clubName = clubRepository.findById(announcement.getClubId()).map(Club::getFullName).orElse("error");
            return new AnoAllResponse(announcement.getId(), announcement.getTitle(), announcement.getDate(), clubName);
        }).collect(Collectors.toList());
    }

    @Override
    public AnoOneResponse getById(Long id) {
        Announcement announcement = announcementRepository.findById(id).orElseThrow(() -> new RuntimeException("No Ano Found!"));
        String clubName = clubRepository.findById(announcement.getClubId()).map(Club::getFullName).orElse("error");
        return new AnoOneResponse(announcement.getTitle(), announcement.getContent(), announcement.getDate(), clubName);
    }

    @Override
    public List<AnoAllResponse> getByUserId(Long userId) {
        List<Long> anoIds = starsRepository.findByUserId(userId).stream().map(Stars::getAnoId).collect(Collectors.toList());
        List<Announcement> announcements = announcementRepository.findByIdIn(anoIds);
        return announcements.stream().map(announcement -> {
            String clubName = clubRepository.findById(announcement.getClubId()).map(Club::getFullName).orElse("error");
            return new AnoAllResponse(announcement.getId(), announcement.getTitle(), announcement.getDate(), clubName);
        }).collect(Collectors.toList());
    }

    @Override
    public List<AnoAllResponse> getByClubIds(Long userId) {
        List<Long> clubIds = starClubRepository.findByUserId(userId).stream().map(StarClub::getClubId).collect(Collectors.toList());
        Long myClubId = userRepository.findById(userId).map(User::getClubId).orElseThrow(() -> new RuntimeException("No User Found!"));
        if (!clubIds.contains(myClubId)){
            clubIds.add(myClubId);
        }
        List<Announcement> announcements = announcementRepository.findByClubIdInOrderByDateDesc(clubIds);
        return announcements.stream().map(announcement -> {
            String clubName = clubRepository.findById(announcement.getClubId()).map(Club::getFullName).orElse("error");
            return new AnoAllResponse(announcement.getId(), announcement.getTitle(), announcement.getDate(), clubName);
        }).collect(Collectors.toList());
    }

    @Override
    public void save(AnoPostRequest anoPostRequest) {
        announcementRepository.save(new Announcement(anoPostRequest.getClubId(), anoPostRequest.getTitle(), anoPostRequest.getContent(), anoPostRequest.getDate()));
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

