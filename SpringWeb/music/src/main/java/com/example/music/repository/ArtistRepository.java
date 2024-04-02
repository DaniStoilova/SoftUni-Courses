package com.example.music.repository;

import com.example.music.model.entity.Artist;
import com.example.music.model.enums.ArtistEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {
    Artist findByName(ArtistEnum artist);
}
