package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_songs",
            joinColumns = @JoinColumn(name = "fk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_song"))
    private List<Song> playlist;


    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Song> playlist) {
        this.playlist = playlist;
    }

    public void addSong(Song song) {
        this.playlist.add(song);
    }

    public void delete() {
        this.playlist.clear();
    }
}
