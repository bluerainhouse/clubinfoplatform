package mis.nccu.clubinfoplatform.controllers;

import mis.nccu.clubinfoplatform.models.User;
import mis.nccu.clubinfoplatform.payload.request.UserUpdateRequest;
import mis.nccu.clubinfoplatform.payload.response.MessageResponse;
import mis.nccu.clubinfoplatform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	@GetMapping("/")
	public User getByUserId(@RequestParam("userId") Long userId) {
		return userService.getUser(userId);
	}

	@PostMapping("/update/{userId}")
	public ResponseEntity updateUser(@RequestParam Long userId, @RequestBody UserUpdateRequest userUpdateRequest){
		userService.updateUser(userId, userUpdateRequest);
		return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
	}
}
