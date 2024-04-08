package com.example.gamestore;

import com.example.gamestore.model.AllGameDto;
import com.example.gamestore.model.DetailDto;
import com.example.gamestore.model.GameAddDto;
import com.example.gamestore.model.OwnedGames;
import com.example.gamestore.services.GameService;
import com.example.gamestore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final String REGISTER_USER = "RegisterUser";
    private final String LOGIN_USER = "LoginUser";
    private final String LOGOUT_USER = "Logout";
    private final String ADD_GAME = "AddGame";
    private final String EDIT_GAME = "EditGame";
    private final String DELETE_GAME = "DeleteGame";
    private final String ALL_GAMES = "AllGames";
    private final String DETAIL_GAME = "DetailGame";
    private final String OWNED_GAMES = "OwnedGames";

    private final UserService userService;

    private final GameService gameService;


    @Autowired
    public Runner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }


    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] commandLine =  input.split("\\|");

        switch (commandLine[0]){
            case REGISTER_USER:
            userService.registerUser(commandLine);
            break;
            case LOGIN_USER:
            userService.loginUser(commandLine);
            break;
            case LOGOUT_USER:
            userService.logout();
            break;
            case ADD_GAME:
                gameService.addGame(new GameAddDto(
                        commandLine[1],
                        new BigDecimal(commandLine[2]),
                        new BigDecimal(commandLine[3]),
                        commandLine[4],
                        commandLine[5],
                        commandLine[6],
                        commandLine[7]));
                break;
            case EDIT_GAME:
                gameService.editGame(Long.parseLong(commandLine[1]),
                        new BigDecimal(commandLine[2].split("=")[1]),
                        new BigDecimal(commandLine[3].split("=")[1]));
                break;
            case DELETE_GAME:
                gameService.deleteGame(Long.parseLong(commandLine[1]));
                break;
            case ALL_GAMES:
               printAllGames();
               break;
            case DETAIL_GAME:
                printDetailsGames(commandLine[1]);
            case OWNED_GAMES:
                printOwnedGames();


        }



    }

    private void printOwnedGames() {

        List<OwnedGames> ownedGames =  gameService.ownedGames();

        ownedGames.forEach(System.out::println);

    }

    private void printDetailsGames(String title) {

        DetailDto details = gameService.detailGames(title);

        System.out.println(details);
    }

    private void printAllGames() {

      List<AllGameDto> games =  gameService.allGames();

      games.forEach(System.out::println);
    }
}
