package mis.nccu.clubinfoplatform.services.impl;

import mis.nccu.clubinfoplatform.models.User;
import mis.nccu.clubinfoplatform.payload.request.UserUpdateRequest;
import mis.nccu.clubinfoplatform.repository.UserRepository;
import mis.nccu.clubinfoplatform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void updateUser(UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(userUpdateRequest.getUserId()).orElseThrow(()-> new RuntimeException("No User Found!"));
        user.setFullName(userUpdateRequest.getFullName());
        user.setClubId(userUpdateRequest.getClubId());
        user.setSelfIntro(userUpdateRequest.getSelfIntro());
        userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException("No User Found!"));
    }
}

