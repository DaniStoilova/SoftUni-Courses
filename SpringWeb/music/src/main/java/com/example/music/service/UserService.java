package com.example.music.service;

import com.example.music.model.binding.UserLoginBindingModel;
import com.example.music.model.binding.UserRegisterBindingModel;

public interface UserService {
    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean findByUsernameAndPassword(String username, String password);

    void login(UserLoginBindingModel userLoginBindingModel);
}
