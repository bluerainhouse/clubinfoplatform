package mis.nccu.clubinfoplatform.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mis.nccu.clubinfoplatform.models.Club;
import mis.nccu.clubinfoplatform.models.StarClub;
import mis.nccu.clubinfoplatform.models.vo.ClubData;
import mis.nccu.clubinfoplatform.payload.request.ClubUpdateRequest;
import mis.nccu.clubinfoplatform.payload.response.ClubDetailResponse;
import mis.nccu.clubinfoplatform.repository.ClubRepository;
import mis.nccu.clubinfoplatform.services.ClubService;
import mis.nccu.clubinfoplatform.services.StarClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    StarClubService starClubService;

    @Override
    public void updateClubDetail(ClubUpdateRequest clubUpdateRequest) {
        Club club = clubRepository.findById(clubUpdateRequest.getClubId()).orElseThrow(() -> new RuntimeException("No Club Found!"));
        ObjectMapper ob = new ObjectMapper();

        String data = "";
        try {
            data = ob.writeValueAsString(clubUpdateRequest.getData());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        club.setData(data);
        clubRepository.save(club);
    }

    @Override
    public List<Club> getStarClubs(Long userId) {
        List<Long> clubIds = starClubService.getByUserId(userId).stream().map(StarClub::getClubId).collect(Collectors.toList());
        return clubRepository.findByIdIn(clubIds);
    }

    @Override
    public ClubDetailResponse getClubDetail(Long clubId) {
        ObjectMapper ob = new ObjectMapper();
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new RuntimeException("No Club Found!"));
        try {
            return new ClubDetailResponse(clubId, ob.readValue(club.getData(), ClubData.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
}

