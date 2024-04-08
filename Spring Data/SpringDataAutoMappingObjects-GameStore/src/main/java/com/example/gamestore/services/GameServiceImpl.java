package com.example.gamestore.services;

import com.example.gamestore.entities.Game;
import com.example.gamestore.model.AllGameDto;
import com.example.gamestore.model.DetailDto;
import com.example.gamestore.model.GameAddDto;
import com.example.gamestore.model.OwnedGames;
import com.example.gamestore.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    private final ModelMapper modelMapper;


    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public void addGame(GameAddDto gameAddDto) {


        Game game = modelMapper.map(gameAddDto, Game.class);

        gameRepository.save(game);

        System.out.println("Added Overwatch");


    }

    @Override
    public void editGame(long id, BigDecimal price, BigDecimal size) {

        Optional<Game> game = gameRepository.findById(id);

        if (game.isEmpty()) {
            return;
        }
        if (size.compareTo(BigDecimal.ZERO) < 0 && price.compareTo(BigDecimal.ZERO) != 0) {
            System.out.println("Enter positive price and size");
            return;

        }
        game.get().setPrice(price);
        game.get().setSize(size);
        gameRepository.save(game.get());
        System.out.println("Edited " + game.get().getTitle());

    }

    @Override
    public void deleteGame(long id) {

        Optional<Game> game = gameRepository.findById(id);

        if (game.isEmpty()) {
            return;
        }
        gameRepository.delete(game.get());
        System.out.println("Deleted Overwatch");
    }

    @Override
    public List<AllGameDto> allGames() {
        return gameRepository.findAll()
                .stream()
                .map(m -> modelMapper.map(m, AllGameDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DetailDto detailGames(String title) {
        Game byTitle = gameRepository.findByTitle(title);

        DetailDto detailDto = modelMapper.map(byTitle, DetailDto.class);


        return detailDto;
    }

    @Override
    public List<OwnedGames> ownedGames() {
        return gameRepository.findAll()
                .stream()
                .map(m -> modelMapper.map(m, OwnedGames.class))
                .collect(Collectors.toList());
    }
}
