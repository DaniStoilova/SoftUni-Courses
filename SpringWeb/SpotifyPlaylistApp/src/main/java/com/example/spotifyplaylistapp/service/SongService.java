package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.SongDTO;
import com.example.spotifyplaylistapp.model.binding.SongAddBindingModel;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;

import java.math.BigDecimal;
import java.util.List;

public interface SongService {
    void add(SongAddBindingModel songAddBindingModel);


    List<SongDTO> findAllSongsByStyleName(StyleEnum styleEnum);


    BigDecimal findTotal();



}
