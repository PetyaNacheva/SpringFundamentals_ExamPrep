package musicdb.service;

import musicdb.model.UserEntity;
import musicdb.model.service.UserServiceModel;

public interface UserService {
    boolean saveUser(UserServiceModel map);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    UserEntity findUserByUsernameAndEmail(String username, String email);
}
