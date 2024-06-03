package mis.nccu.clubinfoplatform.controllers;

import mis.nccu.clubinfoplatform.models.User;
import mis.nccu.clubinfoplatform.payload.request.UserUpdateRequest;
import mis.nccu.clubinfoplatform.payload.response.MessageResponse;
import mis.nccu.clubinfoplatform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	@GetMapping("/detail")
	public User getByUserId(@RequestParam("userId") Long userId) {
		return userService.getUser(userId);
	}

	@GetMapping("/test")
	public String test(){
		return "test";
	}

	@PostMapping("/update")
	public ResponseEntity updateUser(@RequestBody UserUpdateRequest userUpdateRequest){
		userService.updateUser(userUpdateRequest);
		return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
	}
}
