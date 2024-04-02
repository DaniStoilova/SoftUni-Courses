package com.example.spotifyplaylistapp.model.binding;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;


public class SongAddBindingModel {

    @NotNull
    @Size(min=3,max=20,message = "Performer name length must be between 3 and 20 characters!")
    private String performer;

    @NotNull
    @Size(min=3,max=20,message = "Title length must be between 2 and 20 characters!")
    private String title;

    @NotNull
    @Positive(message = "Duration must be a positive!" )
    private Integer duration;

    @PastOrPresent(message="The date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;


    @NotNull(message = "You must select a style!")
    private StyleEnum style;


    public SongAddBindingModel() {
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public StyleEnum getStyle() {
        return style;
    }

    public void setStyle(StyleEnum style) {
        this.style = style;
    }
}
