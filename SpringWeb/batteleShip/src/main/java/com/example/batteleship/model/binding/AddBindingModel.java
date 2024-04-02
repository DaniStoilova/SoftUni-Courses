package com.example.batteleship.model.binding;

import com.example.batteleship.model.entity.Category;
import com.example.batteleship.model.entity.User;
import com.example.batteleship.model.enums.CategoryEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class AddBindingModel {

    private Long id;

    @NotNull
    @Size(min = 2, max = 10,message = "Name must be between 2 and 10 characters!")
    private String name;

    @NotNull(message = "The health must be positive!")
    @Positive
    private Long health;

    @NotNull(message = "The power must be positive!")
    @Positive
    private Long power;

    @NotNull(message = "Created date cannot be in the future")
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull(message = "You must select the category!")
    private CategoryEnum category;


    private User user;

    public AddBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
