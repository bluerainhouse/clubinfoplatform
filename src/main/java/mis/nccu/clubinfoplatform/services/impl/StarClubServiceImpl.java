package mis.nccu.clubinfoplatform.services.impl;

import mis.nccu.clubinfoplatform.models.StarClub;
import mis.nccu.clubinfoplatform.payload.request.StarClubRequest;
import mis.nccu.clubinfoplatform.repository.StarClubRepository;
import mis.nccu.clubinfoplatform.services.StarClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StarClubServiceImpl implements StarClubService {
    @Autowired
    StarClubRepository starClubRepository;

    @Override
    public StarClub getByUserIdAndClubId(Long userId, Long clubId) {
        return starClubRepository.findFirstByUserIdAndClubId(userId, clubId);
    }

    @Override
    public List<StarClub> getByUserId(Long userId) {
        return starClubRepository.findByUserId(userId);
    }

    @Override
    public StarClub save(StarClubRequest starClubRequest) {
        return starClubRepository.save(new StarClub(starClubRequest.getUserId(), starClubRequest.getClubId()));
    }

    @Override
    public void delete(Long id) {
        starClubRepository.deleteById(id);
    }
}

