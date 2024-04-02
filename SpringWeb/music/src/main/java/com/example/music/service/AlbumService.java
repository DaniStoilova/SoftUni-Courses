package com.example.music.service;

import com.example.music.model.binding.AddAlbumBindingModel;
import com.example.music.model.binding.AlbumDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AlbumService{
    void addAlbum(AddAlbumBindingModel addAlbumBindingModel);

    List<AlbumDTO> getAllCopies();

    void remove(Long id);

    BigDecimal getCopies();
}
