package com.example.gamestore.services;


public interface UserService {

    Object registerUser(String[] commandLine);
    String loginUser(String[] input);

    boolean isLoggedUserAdmin();

    String logout();
}
