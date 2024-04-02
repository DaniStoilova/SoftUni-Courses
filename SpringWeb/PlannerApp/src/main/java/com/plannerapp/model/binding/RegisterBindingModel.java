package com.plannerapp.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterBindingModel {

    @NotNull
    @Size(min = 3,max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;

    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Enter valid email!")
    private String email;

    @NotNull
    @Size(min = 3,max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    public RegisterBindingModel() {
    }

    @NotNull
    @Size(min = 3,max = 20, message = "Password length must be between 3 and 20 characters!")


    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
