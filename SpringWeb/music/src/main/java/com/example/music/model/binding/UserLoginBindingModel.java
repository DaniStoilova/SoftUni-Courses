package com.example.music.model.binding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    @NotNull
    @Size(min = 3,max=20,message = "Username length must be between 3 and 20 characters!")
    private String username;
    @NotNull
    @Size(min = 5,max = 20,message = "Password length be between 5 and 20 characters!")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
