package com.example.gamestore.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.regex.Pattern;


@Getter
@Setter
public class RegisterDto {


    public  String PASSWORD_PATTERN = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}";

    private String email;
    private String password;
    private String confirmPass;
    private String fullName;

    public RegisterDto(String email, String password, String confirmPass, String fullName) throws IllegalAccessException {
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
        this.fullName = fullName;
       this.validate();
    }



    private void validate() throws IllegalAccessException {
        if (!email.contains("@") || !email.contains(".")){
                throw new IllegalAccessException("Email must contain @ and .");
        }
        if (!Pattern.matches(PASSWORD_PATTERN, this.password)){
            throw new IllegalAccessException("Invalid password");
        }
        if (!this.password.equals(confirmPass)){
            throw new IllegalAccessException("Password must much");
        }
    }


}
