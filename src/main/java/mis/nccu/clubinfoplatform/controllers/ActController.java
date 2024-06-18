package mis.nccu.clubinfoplatform.controllers;

import mis.nccu.clubinfoplatform.models.Activity;
import mis.nccu.clubinfoplatform.payload.request.ActPostRequest;
import mis.nccu.clubinfoplatform.payload.request.ActPutRequest;
import mis.nccu.clubinfoplatform.payload.response.ActAllResponse;
import mis.nccu.clubinfoplatform.payload.response.ActOneResponse;
import mis.nccu.clubinfoplatform.payload.response.MessageResponse;
import mis.nccu.clubinfoplatform.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/act")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ActController {
    @Autowired
    ActivityService activityService;

    @GetMapping(value = "/search")
    public List<ActAllResponse> getByClubIdAndType(@RequestParam("type") String type) {
        return activityService.getByType(type);
    }

    @GetMapping(value = "/all")
    public List<ActAllResponse> getAll(){
        return activityService.getAll();
    }

    @GetMapping(value = "/get")
    public ActOneResponse getActivity(@RequestParam("actId") Long actId) {
        return activityService.geyById(actId);
    }

    @GetMapping(value = "/follows")
    public List<Activity> getByStarClub(@RequestParam("userId") Long userId) {
        return activityService.getByActIds(userId);
    }

    @GetMapping(value = "/new")
    public Activity getNewewstActivity(@RequestParam("clubId") Long clubId, @RequestParam("type") String type) {
        return activityService.getNewewstActivity(clubId, type);
    }

    @PostMapping(value = "/")
    public ResponseEntity insertActs(@RequestBody ActPostRequest actPostRequest) {
        activityService.save(actPostRequest);
        return ResponseEntity.ok(new MessageResponse("Activity saved successfully!"));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateActs(@PathVariable Long id, @RequestBody ActPutRequest actPutRequest) {
        activityService.update(id, actPutRequest);
        return ResponseEntity.ok(new MessageResponse("Activity updated successfully!"));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        activityService.delete(id);
        return ResponseEntity.ok(new MessageResponse("Activity deleted successfully!"));
    }

}

