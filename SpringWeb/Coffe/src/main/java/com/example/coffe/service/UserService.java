package com.example.coffe.service;

import com.example.coffe.model.binding.LoginUserBindingModel;
import com.example.coffe.model.binding.UserRegisterBindingModel;
import com.example.coffe.model.binding.UserViewModel;
import com.example.coffe.model.entity.User;

import java.util.List;

public interface UserService {
    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(LoginUserBindingModel loginUserBindingModel);


    User findById(Long id);

   List<UserViewModel> findAllUserAndCountOrderOrderByCountOrderDesc();
}
