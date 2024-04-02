package com.example.music.model.binding;

import com.example.music.model.enums.ArtistEnum;
import com.example.music.model.entity.User;
import com.example.music.model.enums.GenreEnum;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddAlbumBindingModel {


    @NotNull
    @Size(min = 3,max=20,message = "Name must be between 3 and 20 characters!")
    private String name;
    @NotNull
    @Size(min = 3,max=20,message = "Image url must be minimum 5 characters!")
    private String imageUrl;
    @NotNull
    @Size(min = 5,message = "Description must be minimum 5 characters!")
    private String descriptions;
    @NotNull(message = "Copies must be more than 10!")
    @Min(10)
    private Integer copies;

    @NotNull
    @Positive(message = "Price must be a positive number!")
    private BigDecimal price;

    @PastOrPresent(message = "Release date cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releasedDate;

    private String producer;

    @NotNull(message = "You must select genre")
    private GenreEnum genre;

    @NotNull(message = "You must select artist")
    private ArtistEnum artist;

    private User addedFrom;

    public AddAlbumBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public ArtistEnum getArtist() {
        return artist;
    }

    public void setArtist(ArtistEnum artist) {
        this.artist = artist;
    }

    public User getAddedFrom() {
        return addedFrom;
    }

    public void setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
    }
}
