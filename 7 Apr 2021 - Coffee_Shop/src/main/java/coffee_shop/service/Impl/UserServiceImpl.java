package coffee_shop.service.Impl;

import coffee_shop.model.User;
import coffee_shop.model.service.UserServiceModel;
import coffee_shop.model.view.UserViewModel;
import coffee_shop.repository.UserRepository;
import coffee_shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean saveUser(UserServiceModel userServiceModel) {
        try {
            userRepository.save(modelMapper.map(userServiceModel, User.class));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).map(u->modelMapper.map(u, UserServiceModel.class)).orElse(null);
    }

    @Override
    public User findById(UserServiceModel user) {
       return userRepository.findById(user.getId()).map(u->modelMapper.map(u, User.class)).orElse(null);

    }

    @Override
    public List<UserViewModel> findAllUsersByCountOfOrdersOrderByCountDesc() {
        return userRepository.findAllByOrdersCountDesc().stream().map(u->{
          UserViewModel user = new UserViewModel();
          user.setUsername(u.getUsername());
          user.setCountOfOrders(u.getOrders().size());
            return user;
        }).collect(Collectors.toList());

    }
}
