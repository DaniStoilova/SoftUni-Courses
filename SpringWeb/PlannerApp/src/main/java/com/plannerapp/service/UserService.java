package com.plannerapp.service;

import com.plannerapp.model.binding.RegisterBindingModel;
import com.plannerapp.model.binding.UserLoginBindingModel;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;

import java.util.List;

public interface UserService {
    void register(RegisterBindingModel registerBindingModel);

    boolean findByUsernameAndPassword(String username, String password);

    void login(UserLoginBindingModel userLoginBindingModel);

    User findById(Long id);


}
