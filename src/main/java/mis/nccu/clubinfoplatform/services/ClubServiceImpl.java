package mis.nccu.clubinfoplatform.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mis.nccu.clubinfoplatform.models.Club;
import mis.nccu.clubinfoplatform.models.vo.ClubData;
import mis.nccu.clubinfoplatform.payload.request.ClubUpdateRequest;
import mis.nccu.clubinfoplatform.payload.response.ClubDetailResponse;
import mis.nccu.clubinfoplatform.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    ClubRepository clubRepository;

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

