package coffee_shop.service;

import coffee_shop.model.User;
import coffee_shop.model.service.UserServiceModel;
import coffee_shop.model.view.UserViewModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean saveUser(UserServiceModel userServiceModel);

  UserServiceModel findByUsernameAndPassword(String username, String password);

    User findById(UserServiceModel user);


    List<UserViewModel> findAllUsersByCountOfOrdersOrderByCountDesc();
}
