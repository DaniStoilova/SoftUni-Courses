package com.resellerapp.service;

import com.resellerapp.model.binding.UserLoginBindingModel;
import com.resellerapp.model.binding.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean findByUsernameAndPassword(String username, String password);

    void login(UserLoginBindingModel userLoginBindingModel);
}
