package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Style extends BaseEntity {


    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private StyleEnum styleName;

    @Column
    private String description;

    @OneToMany(mappedBy = "style")
    private Set<Song> songs;

    public Style() {
    }

    public StyleEnum getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleEnum styleName) {
        this.styleName = styleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
