package com.example.andres.model.binding;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    @NotNull
    @Size(min = 2,message ="Username length must be more than two characters")
    private String username;
    @NotNull
    @Size(min = 2,message =  "Password length must be more than two characters")
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
