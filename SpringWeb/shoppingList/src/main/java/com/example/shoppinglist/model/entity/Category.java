package com.example.shoppinglist.model.entity;

import com.example.shoppinglist.model.enums.CategoryEnum;
import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
