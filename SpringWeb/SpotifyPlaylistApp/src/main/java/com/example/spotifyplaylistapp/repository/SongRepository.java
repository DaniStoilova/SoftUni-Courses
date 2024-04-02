package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

    List<Song> findAllByStyle_StyleName(StyleEnum styleEnum);


    @Query("select s, u from Song s join s.users u on u.id = :id")
    List<Song> findAllByUserId(@Param("id") Long id);


    @Query("SELECT SUM(s.duration) FROM Song s ")
    BigDecimal findTotalDuration();


}
