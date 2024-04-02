package com.likebookapp.model.binding;

import com.likebookapp.model.enums.MoodEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddPostBindingModel {

    @Size(min=2,max=150,message = "Content length must be between 2 and 50 characters!")
    @NotNull
    private String content;

    @NotNull(message = "You must select a mood!")
    private MoodEnum mood;

    public AddPostBindingModel() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodEnum getMood() {
        return mood;
    }

    public void setMood(MoodEnum mood) {
        this.mood = mood;
    }
}
