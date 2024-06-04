package mis.nccu.clubinfoplatform.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import mis.nccu.clubinfoplatform.models.Club;
import mis.nccu.clubinfoplatform.models.vo.ClubData;
import mis.nccu.clubinfoplatform.payload.request.ClubUpdateRequest;
import mis.nccu.clubinfoplatform.payload.response.ClubDetailResponse;
import mis.nccu.clubinfoplatform.payload.response.MessageResponse;
import mis.nccu.clubinfoplatform.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/club")
public class ClubController {

	@Autowired
	ClubService clubService;
	@GetMapping("/detail")
	public ClubDetailResponse getByClubId(@RequestParam("clubId") Long clubId) {
		return clubService.getClubDetail(clubId);
	}

	@GetMapping("/starclub")
	public List<Club> getStarClubs(@RequestParam("userId") Long userId) {
		return clubService.getStarClubs(userId);
	}

	@GetMapping("/all")
	public List<Club> getAllClubs() {
		return clubService.getAllClubs();
	}

	@GetMapping("/test")
	public String test(){
		return "test";
	}

	@PostMapping("/update")
	public ResponseEntity updateClubDetail(@RequestBody ClubUpdateRequest clubUpdateRequest){
		clubService.updateClubDetail(clubUpdateRequest);
		return ResponseEntity.ok(new MessageResponse("Club updated successfully!"));
	}
}
