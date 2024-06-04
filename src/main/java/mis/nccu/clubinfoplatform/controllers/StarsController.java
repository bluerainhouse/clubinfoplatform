package mis.nccu.clubinfoplatform.controllers;// package mis.nccu.clubinfoplatform.controllers;

import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.models.Stars;
import mis.nccu.clubinfoplatform.payload.request.FollowRequest;
import mis.nccu.clubinfoplatform.payload.request.StarRequest;
import mis.nccu.clubinfoplatform.payload.response.MessageResponse;
import mis.nccu.clubinfoplatform.services.FollowsService;
import mis.nccu.clubinfoplatform.services.StarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stars")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StarsController {
    @Autowired
    StarsService starsService;

    @GetMapping(value = "/search")
    public Stars getByUserId(@RequestParam("userId") Long userId, @RequestParam("anoId") Long anoId) {
        return starsService.getByUserIdAndAnoId(userId, anoId);
    }

    @PostMapping(value = "/")
    public Stars insertStars(@RequestBody StarRequest starRequest) {
        return starsService.save(starRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        starsService.delete(id);
        return ResponseEntity.ok(new MessageResponse("Stars deleted successfully!"));
    }

}

