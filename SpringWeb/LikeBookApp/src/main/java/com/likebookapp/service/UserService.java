package com.likebookapp.service;

import com.likebookapp.model.binding.UserLoginBindingModel;
import com.likebookapp.model.binding.UserRegisterBindingModel;
import com.likebookapp.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void register(UserRegisterBindingModel userRegisterBindingModel);


    void login(UserLoginBindingModel userLoginBindingModel);


    boolean findByUsernameAndPassword(String username, String password);

    User findById(Long id);

    User findUserById(Long id);
}
