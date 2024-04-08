package com.example.gamestore.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Order extends BaseEntity{

    @ManyToOne
    private User buyer;

    @ManyToMany
    private Set<Game> games;

    public Order() {
    }

//    public Order(User user, Set<Game> games) {
//        this.user = user;
//        this.games = games;
//    }
}
