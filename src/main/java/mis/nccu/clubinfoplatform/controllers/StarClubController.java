package mis.nccu.clubinfoplatform.controllers;// package mis.nccu.clubinfoplatform.controllers;

import mis.nccu.clubinfoplatform.models.StarClub;
import mis.nccu.clubinfoplatform.payload.request.StarClubRequest;
import mis.nccu.clubinfoplatform.payload.response.MessageResponse;
import mis.nccu.clubinfoplatform.services.StarClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/star-club")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StarClubController {
    @Autowired
    StarClubService starClubService;

    @GetMapping(value = "/search")
    public StarClub getByUserId(@RequestParam("userId") Long userId, @RequestParam("clubId") Long clubId) {
        return starClubService.getByUserIdAndClubId(userId, clubId);
    }

    @PostMapping(value = "/")
    public StarClub insertStars(@RequestBody StarClubRequest starClubRequest) {
        return starClubService.save(starClubRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        starClubService.delete(id);
        return ResponseEntity.ok(new MessageResponse("Stars deleted successfully!"));
    }

}

