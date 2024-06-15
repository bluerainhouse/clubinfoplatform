package mis.nccu.clubinfoplatform.controllers;// package mis.nccu.clubinfoplatform.controllers;

import mis.nccu.clubinfoplatform.models.Follows;
import mis.nccu.clubinfoplatform.payload.request.FollowRequest;
import mis.nccu.clubinfoplatform.payload.response.MessageResponse;
import mis.nccu.clubinfoplatform.services.FollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FollowsController {
    @Autowired
    FollowsService followsService;

    @GetMapping(value = "/search")
    public Follows getByUserIdAndActivityId(@RequestParam("userId") Long userId, @RequestParam("activityId") Long activityId) {
        return followsService.getByUserIdAndActivityId(userId, activityId);
    }

    @PostMapping(value = "/")
    public Follows insertFollows(@RequestBody FollowRequest followRequest) {
        return followsService.save(followRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        followsService.delete(id);
        return ResponseEntity.ok(new MessageResponse("Follows deleted successfully!"));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateFollows(@PathVariable Long id, @RequestBody FollowRequest followRequest) {
        followsService.update(id, followRequest);
        return ResponseEntity.ok(new MessageResponse("Follows updated successfully!"));
    }

}

