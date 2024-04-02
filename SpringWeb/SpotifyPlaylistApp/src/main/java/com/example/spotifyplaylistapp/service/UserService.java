package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.binding.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.binding.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean findByUsernameAndPassword(String username, String password);

    void login(UserLoginBindingModel userLoginBindingModel);


    void addToPlaylist(Long id);

    List<Song> getUserSongs();

    void remove(Long id);

    void removeAll();
}
