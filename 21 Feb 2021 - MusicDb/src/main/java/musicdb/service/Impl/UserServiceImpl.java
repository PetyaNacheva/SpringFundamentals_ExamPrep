package musicdb.service.Impl;

import musicdb.model.UserEntity;
import musicdb.model.service.UserServiceModel;
import musicdb.repository.UserRepository;
import musicdb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            userRepository.save(modelMapper.map(userServiceModel, UserEntity.class));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

        UserServiceModel user = userRepository.findByUsernameAndPassword(username, password).map(u -> modelMapper.map(u, UserServiceModel.class)).orElse(null);

        return user;
    }

    @Override
    public UserEntity findUserByUsernameAndEmail(String username, String email) {
        return userRepository.findByUsernameAndEmail(username, email);
    }
}
