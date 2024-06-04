package mis.nccu.clubinfoplatform.controllers;// package mis.nccu.clubinfoplatform.controllers;

import mis.nccu.clubinfoplatform.models.Announcement;
import mis.nccu.clubinfoplatform.payload.request.AnoPostRequest;
import mis.nccu.clubinfoplatform.payload.request.AnoPutRequest;
import mis.nccu.clubinfoplatform.payload.response.AnoAllResponse;
import mis.nccu.clubinfoplatform.payload.response.AnoOneResponse;
import mis.nccu.clubinfoplatform.payload.response.MessageResponse;
import mis.nccu.clubinfoplatform.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ano")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AnoController {
    @Autowired
    AnnouncementService announcementService;

    @GetMapping(value = "/search")
    public List<AnoAllResponse> getByUserId(@RequestParam("userId") Long userId) {
        return announcementService.getByUserId(userId);
    }

    @GetMapping(value = "/get")
    public AnoOneResponse getById(@RequestParam("anoId") Long anoId) {
        return announcementService.getById(anoId);
    }

    @GetMapping(value = "/starClub")
    public List<AnoAllResponse> getByStarClub(@RequestParam("userId") Long userId) {
        return announcementService.getByClubIds(userId);
    }

    @GetMapping(value = "/all")
    public List<AnoAllResponse> getAll() {
        return announcementService.getAll();
    }

    @PostMapping(value = "/")
    public ResponseEntity insertAnos(@RequestBody AnoPostRequest anoPostRequest) {
        announcementService.save(anoPostRequest);
        return ResponseEntity.ok(new MessageResponse("Announcement saved successfully!"));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateAnos(@PathVariable Long id, @RequestBody AnoPutRequest anoPutRequest) {
        announcementService.update(id, anoPutRequest);
        return ResponseEntity.ok(new MessageResponse("Announcement updated successfully!"));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        announcementService.delete(id);
        return ResponseEntity.ok(new MessageResponse("Announcement deleted successfully!"));
    }

}

