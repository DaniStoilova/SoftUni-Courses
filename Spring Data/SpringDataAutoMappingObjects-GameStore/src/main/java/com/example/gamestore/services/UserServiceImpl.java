package com.example.gamestore.services;

import com.example.gamestore.entities.User;
import com.example.gamestore.model.LoginDto;
import com.example.gamestore.model.RegisterDto;
import com.example.gamestore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private User loggInUser;

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public String registerUser(String[] input) {

        final String email = input[1];
        final String password =  input[2];
        final String confirmPassword = input[3];
        final String fullName = input[4];

        RegisterDto registerDto;

    try {
        registerDto = new RegisterDto(email,password,confirmPassword,fullName);

    }catch (Exception e){
        String output = "Incorrect email.";
        System.out.println("Incorrect email.");
       return output;
    }
    if (this.userRepository.findFirstByEmail(registerDto.getEmail()).isPresent()){
        return "Email already exist";

    }

    User user = this.modelMapper.map(registerDto,User.class);

    if (this.userRepository.count() == 0){
        user.setIsAdministrator(true);
    }else{
        user.setIsAdministrator(false);
    }

        this.userRepository.saveAndFlush(user);


        String output = fullName + " was registered";

        System.out.println(output);

        return output;
    }

    @Override
    public String loginUser(String[] input) {
        if (this.loggInUser != null) return "User is already logged.";

        final String email = input[1];
        final String password = input[2];

        User user;

        Optional<User> byEmailAndPassword =
                this.userRepository.findByEmailAndPassword(email, password);

        if (byEmailAndPassword.isEmpty()){
            String output = "Incorrect user/ password";
            System.out.println(output);
            return output;
        }

        final LoginDto loginDto = new LoginDto(email, password);

        try {
            loginDto.validate(byEmailAndPassword.get().getPassword());
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }

        this.loggInUser = byEmailAndPassword.get();


        String output = "Successfully logged in " + loggInUser.getFullName();

        System.out.println(output);

        return output;
    }

    @Override
    public boolean isLoggedUserAdmin() {
        return this.loggInUser != null && this.loggInUser.getIsAdministrator();
    }

    @Override
    public String logout() {
        if (this.loggInUser == null){
            String output = "Cannot log out. No user was logged in.";
            System.out.println(output);
            return output;
        }else{

            this.loggInUser = null;
            String output = "User Ivan successfully logged out";
            System.out.println(output);
            return output;
        }

    }
}
