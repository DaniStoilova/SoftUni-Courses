package com.example.andres.service;

import com.example.andres.model.binding.UserLoginBindingModel;
import com.example.andres.model.binding.UserRegisterBindingModel;

public interface UserService {
    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean findByUsernameAndPassword(String username, String password);

    void login(UserLoginBindingModel userLoginBindingModel);
}
