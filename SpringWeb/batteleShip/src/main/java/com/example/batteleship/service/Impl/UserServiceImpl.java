package com.example.batteleship.service.Impl;

import com.example.batteleship.model.binding.UserLoginBindingModel;
import com.example.batteleship.model.binding.UserRegisterBindingModel;
import com.example.batteleship.model.entity.User;
import com.example.batteleship.repository.UserRepository;
import com.example.batteleship.service.UserService;
import com.example.batteleship.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

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

        User user = modelMapper.map(userRegisterBindingModel, User.class);

        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

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


    }
}
