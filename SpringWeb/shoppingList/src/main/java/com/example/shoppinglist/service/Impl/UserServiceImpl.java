package com.example.shoppinglist.service.Impl;

import com.example.shoppinglist.model.binding.UserLoginBindingModel;
import com.example.shoppinglist.model.binding.UserRegisterBindingModel;
import com.example.shoppinglist.model.entity.User;
import com.example.shoppinglist.repository.UserRepository;
import com.example.shoppinglist.service.UserService;
import com.example.shoppinglist.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    private CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel,User.class);

        if(userRepository.findByUsername(userRegisterBindingModel.getUsername()) != null){
            return;
        }

        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);

    }

    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(user == null){
            return false;
        }

      return  passwordEncoder.matches(password,user.getPassword());


    }

    @Override
    public void login(UserLoginBindingModel userLoginBindingModel) {
        User user = userRepository.findByUsername(userLoginBindingModel.getUsername());

        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());
//        currentUser.setLoggedIn(true);

    }
}
