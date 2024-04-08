package com.example.gamestore.services;

import com.example.gamestore.model.AllGameDto;
import com.example.gamestore.model.DetailDto;
import com.example.gamestore.model.GameAddDto;
import com.example.gamestore.model.OwnedGames;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


public interface GameService {


    void addGame(GameAddDto gameAddDto);

    void editGame(long id, BigDecimal price, BigDecimal size);

    void deleteGame(long id);

    List<AllGameDto> allGames();

    DetailDto detailGames(String title);

    List<OwnedGames> ownedGames();
}
