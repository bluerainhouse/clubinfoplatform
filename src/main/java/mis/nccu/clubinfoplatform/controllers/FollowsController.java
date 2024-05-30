package mis.nccu.clubinfoplatform.controllers;// package mis.nccu.clubinfoplatform.controllers;

import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.payload.request.FollowRequest;
import mis.nccu.clubinfoplatform.services.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
//@CrossOrigin(origins = "http://localhost:3000") // 指定允許的來源
@CrossOrigin(origins = "*", maxAge = 3600)
public class FollowsController {
    @Autowired
    FollowsService followsService;

    @GetMapping(value = "/search")
    public List<Follows> getByClubId(@RequestParam("clubId") Long clubId) {
        return followsService.getByClubId(clubId);
    }

    @PostMapping(value = "/")
    public void insertFollows(@RequestBody FollowRequest followRequest) {
        Follows follows = new Follows(followRequest.getUserId(), followRequest.getClubId());
        followsService.saveOrUpdate(follows);
    }

    @PutMapping(value = "/{id}")
    public void updateFollows(@RequestParam Long id, @RequestBody FollowRequest followRequest) {
        Follows follows = followsService.getById(id);
        follows.setUserId(followRequest.getUserId());
        follows.setClubId(followRequest.getClubId());
        followsService.saveOrUpdate(follows);
    }

}

