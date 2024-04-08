package com.example.gamestore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table
public class Game extends BaseEntity{

    @Column(nullable = false)
    private String title;

    @Column
    private String trailer;

    @Column
    private String  imageThumbnail;

    @Column
    private BigDecimal size;

    @Column
    private BigDecimal price;

    @Column
    private String description;

    @Column
    private LocalDate releaseDate;

    public Game() {
    }

    public Game(String title, String trailer, String imageThumbnail, BigDecimal size, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }
}
