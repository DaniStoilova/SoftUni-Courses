package com.example.andres.model.binding;

import jakarta.validation.constraints.*;

public class UserRegisterBindingModel {

    @NotNull
    @Size(min = 2, message = "Username length must be more than two characters")
    private String username;
    @NotNull
    @Size(min = 2,message = "Password length must be more than two characters")
    private String password;
    @NotNull
    @Size(min = 2)
    private String confirmPassword;

    @NotBlank
    @Email
    private String email;

    @NotNull(message = "Must be a positive number")
    @Positive
    private Integer budget;

    public UserRegisterBindingModel() {
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

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }
}
