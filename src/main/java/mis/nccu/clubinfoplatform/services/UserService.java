package mis.nccu.clubinfoplatform.services;

import mis.nccu.clubinfoplatform.models.User;
import mis.nccu.clubinfoplatform.payload.request.UserUpdateRequest;

public interface UserService {

    void updateUser(UserUpdateRequest userUpdateRequest);

    User getUser(Long userId);
}

