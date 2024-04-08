package com.example.json.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="users")
public class User extends BaseEntity{

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @Column
    private int age;

    @OneToMany(targetEntity = Product.class,mappedBy = "seller",fetch = FetchType.EAGER)
    private Set<Product> productsSale;

    @OneToMany(targetEntity = Product.class,mappedBy = "buyer",fetch = FetchType.EAGER)
    private Set<Product> soldProducts;

    @ManyToMany
    private Set<User> friends;

    public User() {
        this.productsSale = new HashSet<>();
        this.soldProducts = new HashSet<>();
        this.friends = new HashSet<>();
    }

    public User(String firstName, String lastName, Integer age) {
        this();

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
