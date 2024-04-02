package com.plannerapp.service.Impl;

import com.plannerapp.model.binding.RegisterBindingModel;
import com.plannerapp.model.binding.UserLoginBindingModel;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.UserService;
import com.plannerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void register(RegisterBindingModel registerBindingModel) {
        User user = modelMapper.map(registerBindingModel,User.class);

        user.setPassword(passwordEncoder.encode(registerBindingModel.getPassword()));

        userRepository.save(user);


    }

    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(user == null){
            return false;
        }


        return passwordEncoder.matches(password,user.getPassword());
    }

    @Override
    public void login(UserLoginBindingModel userLoginBindingModel) {

        User user = userRepository.findByUsername(userLoginBindingModel.getUsername());

        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());
//        currentUser.setLoggedIn(true);

    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
