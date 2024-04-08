package com.example.gamestore.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    private String email;
    private String password;

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public void validate(String pass){
        if (!password.equals(pass)){
            throw new IllegalArgumentException("Password is not valid");
        }


    }
}
