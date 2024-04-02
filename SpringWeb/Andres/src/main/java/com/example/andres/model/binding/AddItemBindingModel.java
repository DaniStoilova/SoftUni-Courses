package com.example.andres.model.binding;

import com.example.andres.model.enums.CategoryEnum;
import com.example.andres.model.enums.GenreEnum;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class AddItemBindingModel {

    @NotNull
    @Size(min = 2, message = "Name length must be more than two characters")
    private String name;
    @NotNull
    @Size(min = 3, message = "Description length must be more than two characters")
    private String description;

    @NotNull(message = "Incorrect price")
    @Positive
    private BigDecimal price;

    @NotNull
    private CategoryEnum category;

    @NotNull
    private GenreEnum genre;

    public AddItemBindingModel() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }
}
