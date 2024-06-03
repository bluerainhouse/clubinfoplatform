package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.User;
import mis.nccu.clubinfoplatform.payload.request.UserUpdateRequest;

public interface UserService {

    void updateUser(Long userId, UserUpdateRequest userUpdateRequest);

    User getUser(Long userId);
}

