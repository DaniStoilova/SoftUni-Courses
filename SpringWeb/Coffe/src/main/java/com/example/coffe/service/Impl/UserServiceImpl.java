package com.example.coffe.service.Impl;

import com.example.coffe.init.CurrentUser;
import com.example.coffe.model.binding.LoginUserBindingModel;
import com.example.coffe.model.binding.UserRegisterBindingModel;
import com.example.coffe.model.binding.UserViewModel;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.UserRepository;
import com.example.coffe.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final CurrentUser currentUser;

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
    public boolean login(LoginUserBindingModel loginUserBindingModel) {
        User user = userRepository.findByUsername(loginUserBindingModel.getUsername());

        if (user == null){
            return false;
        }

        boolean pass = passwordEncoder.matches(loginUserBindingModel.getPassword(), user.getPassword());

        if (pass) {
            currentUser.setId(user.getId());
            currentUser.setUsername(user.getUsername());
        }

        return pass;

    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUserAndCountOrderOrderByCountOrderDesc() {
        return userRepository
                .findAllByOrdersCountDesc()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setCount(user.getOrders().size());

                    return userViewModel;
                }).collect(Collectors.toList());
    }


}


