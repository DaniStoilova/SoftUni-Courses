package com.example.andres.service.Impl;

import com.example.andres.model.binding.UserLoginBindingModel;
import com.example.andres.model.binding.UserRegisterBindingModel;
import com.example.andres.model.entity.User;
import com.example.andres.model.helper.CurrentUser;
import com.example.andres.repo.UserRepository;
import com.example.andres.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    private CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {

        if (userRegisterBindingModel == null) {
            return;
        }

        String username = userRegisterBindingModel.getUsername();

        if (userRepository.findByUsername(username) != null) {
            return;
        }

        User user = modelMapper.map(userRegisterBindingModel,User.class);

        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);


    }

    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null){
            return false;
        }

        return passwordEncoder.matches(password,user.getPassword());
    }

    @Override
    public void login(UserLoginBindingModel userLoginBindingModel) {
        User user = userRepository.findByUsername(userLoginBindingModel.getUsername());

            currentUser.setId(user.getId());
            currentUser.setUsername(user.getUsername());
            currentUser.setLogged(true);

    }
}
