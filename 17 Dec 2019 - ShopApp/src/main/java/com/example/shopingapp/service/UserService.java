package com.example.shopingapp.service;

import com.example.shopingapp.models.service.UserServiceModel;

public interface UserService {
    boolean saveUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserServiceModel findByUsername(String username);
}
