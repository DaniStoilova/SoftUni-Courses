package com.example.gamestore.entities;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class User extends BaseEntity{

    // email, password, full name, list
    //of games and information on whether he/she is an administrator or not

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @ManyToMany
    private Set<Game> games;

    @Column(nullable = false)
    private Boolean isAdministrator;

    @OneToMany
    private Set<Order> orders;

    public User() {

    }

    public User(String email, String password, String fullName, Set<Game> games, Boolean isAdministrator, Set<Order> orders) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.games = games;
        this.isAdministrator = isAdministrator;
        this.orders = orders;
    }
}
