package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodEnum;

import javax.persistence.*;

@Entity
@Table(name="moods")
public class Mood extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private MoodEnum moodName;

    @Column
    private String Description;

    public Mood() {
    }

    public MoodEnum getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodEnum moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
