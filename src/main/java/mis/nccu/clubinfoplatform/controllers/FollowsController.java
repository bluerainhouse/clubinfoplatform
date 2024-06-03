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
    public List<Follows> getByUserId(@RequestParam("userId") Long userId) {
        return followsService.getByUserId(userId);
    }

    @PostMapping(value = "/")
    public void insertFollows(@RequestBody FollowRequest followRequest) {
        followsService.save(followRequest);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateFollows(@PathVariable Long id, @RequestBody FollowRequest followRequest) {
        followsService.update(id, followRequest);
        return ResponseEntity.ok(new MessageResponse("Follows updated successfully!"));
    }

}

