package com.example.batteleship.model.binding;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotNull
    @Size(min = 3,max = 10,message = "Username length be between 3 and 10 characters!")
    private String username;
    @NotNull
    @Size(min = 5,max = 20,message = "Full name length be between 5 and 20 characters!")
    private String fullName;
    @NotNull
    @Size(min = 3,message = "Password length must be more than 3 characters!")
    private String password;

    @NotNull
    @Size(min = 3,message = "Password length must be more than 3 characters!")
    private String confirmPassword;

    @NotBlank(message = "Enter valid email address!")
    @Email(message = "Enter valid email address!")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRegisterBindingModel() {
    }
}
