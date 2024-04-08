package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PlayerImport;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidationUtils;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static String PLAYER_PATH = "src/main/resources/files/json/players.json";

    private PlayerRepository playerRepository;

    private TeamRepository teamRepository;

    private PictureRepository pictureRepository;

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtils validationUtils;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository, PictureRepository pictureRepository, ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
    }


    @Override
    public String importPlayers() throws IOException {

        StringBuilder sb = new StringBuilder();

        String fileContent = this.readPlayersJsonFile();

        List<PlayerImport> collect = Arrays.stream
                (gson.fromJson(fileContent, PlayerImport[].class)).collect(Collectors.toList());

        for (PlayerImport playerImport : collect) {

            Optional<Team> name = teamRepository.findFirstByName(playerImport.getTeam().getName());
            Optional<Picture> url = pictureRepository.findFirstByUrl(playerImport.getPicture().getUrl());


            if (!validationUtils.isValid(playerImport) || name.isEmpty() || url.isEmpty()){
                sb.append("Invalid player")
                        .append(System.lineSeparator());

                continue;
            }

            Player playerToSave = this.modelMapper.map(playerImport, Player.class);
            playerToSave.setTeam(name.get());
            playerToSave.setPicture(url.get());

            this.playerRepository.save(playerToSave);

            sb.append(String.format("Successfully imported player: %s %s",
                    playerImport.getFirstName(),
                    playerImport.getLastName())).append(System.lineSeparator());

        }


        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYER_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();

        List<Player> players = playerRepository.findPlayersBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000));

        players.forEach(el->sb.append(String.format("Player name: %s %s \n" +
                        "\tNumber: %d\n" +
                        "\tSalary: %.2f\n" +
                        "\tTeam: %s\n",
                el.getFirstName(),
                el.getLastName(),
                el.getNumber(),
                el.getSalary(),
                el.getTeam().getName())));


        return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {

        StringBuilder sb = new StringBuilder();

        List<Player> northHub = playerRepository.findAllByTeamNameOrderById("North Hub");

        sb.append(String.format("Team North Hub\n"));

        northHub.forEach(el->sb.append(String.format("\tPlayer name: %s %s - %s\n " +
                                "\tNumber: %d\n",
                el.getFirstName(),
                el.getLastName(),
                el.getPosition(),
                el.getNumber())));


        return sb.toString().trim();
    }
}
