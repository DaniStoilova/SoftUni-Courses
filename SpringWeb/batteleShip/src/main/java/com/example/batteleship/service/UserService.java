package com.example.batteleship.service;

import com.example.batteleship.model.binding.UserLoginBindingModel;
import com.example.batteleship.model.binding.UserRegisterBindingModel;

public interface UserService {
    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean findByUsernameAndPassword(String username, String password);

    void login(UserLoginBindingModel userLoginBindingModel);
}
