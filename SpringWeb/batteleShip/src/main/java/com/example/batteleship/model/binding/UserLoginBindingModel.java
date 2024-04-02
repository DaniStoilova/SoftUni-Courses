package com.example.batteleship.model.binding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    @NotNull
    @Size(min = 3,max=20,message = "Username length must be between 3 and 10 characters!")
    private String username;
    @NotNull
    @Size(min = 3,message = "Password length must be more than 3 characters!")
    private String Password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}
