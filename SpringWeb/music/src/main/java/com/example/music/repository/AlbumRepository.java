package com.example.music.repository;

import com.example.music.model.entity.Album;
import com.example.music.model.enums.ArtistEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

    List<Album> findAllByOrderByCopiesDesc();
    List<Album> findAllByArtist_Name(ArtistEnum artist_name);

    @Query("SELECT Sum(a.copies) FROM Album a")
    BigDecimal getCopies();
}
