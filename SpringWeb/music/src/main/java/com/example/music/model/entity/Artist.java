package com.example.music.model.entity;

import com.example.music.model.enums.ArtistEnum;
import jakarta.persistence.*;

@Entity
@Table(name="artists")
public class Artist extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ArtistEnum name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String careerInformation;

    public Artist() {
    }

    public ArtistEnum getName() {
        return name;
    }

    public void setName(ArtistEnum name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
