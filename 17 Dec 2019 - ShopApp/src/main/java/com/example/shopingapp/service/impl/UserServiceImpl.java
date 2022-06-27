package com.example.shopingapp.service.impl;

import com.example.shopingapp.models.entity.User;
import com.example.shopingapp.models.service.UserServiceModel;
import com.example.shopingapp.repositories.UserRepository;
import com.example.shopingapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public UserServiceModel findByUsername(String username) {
        return userRepository.findByUsername(username).map(u->modelMapper.map(u, UserServiceModel.class)).orElse(null);
    }
}
