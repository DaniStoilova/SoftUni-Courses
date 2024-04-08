package com.example.football.service.impl;
import com.example.football.models.dto.PlayerImport;
import com.example.football.models.dto.PlayerWrapper;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtils;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static String PLAYER_PATH = "src/main/resources/files/xml/players.xml";

    private PlayerRepository playerRepository;
    private StatRepository statRepository;

    private TeamRepository teamRepository;

    private TownRepository townRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    public PlayerServiceImpl(PlayerRepository playerRepository, StatRepository statRepository, TeamRepository teamRepository, TownRepository townRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils) {
        this.playerRepository = playerRepository;
        this.statRepository = statRepository;
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYER_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException {
        StringBuilder sb = new StringBuilder();


        List<PlayerImport> players = xmlParser.fromFile(PLAYER_PATH, PlayerWrapper.class).getPlayers();

        for (PlayerImport player : players) {

            Optional<Team> team = this.teamRepository.findFirstByName(player.getTeam().getName());

            Optional<Town> town = this.townRepository.findFirstByName(player.getTown().getName());

            Optional<Stat> stat = this.statRepository.findById(player.getStat().getId());

            Optional<Player> byEmail = this.playerRepository.findByEmail(player.getEmail());


            if (team.isEmpty() || town.isEmpty() || stat.isEmpty() ||  byEmail.isPresent() || !validationUtils.isValid(player)){
                sb.append("Invalid Player")
                        .append(System.lineSeparator());
                continue;

            }

            Player playerToSave = this.modelMapper.map(player, Player.class);

            playerToSave.setTeam(team.get());
            playerToSave.setTown(town.get());
            playerToSave.setStat(stat.get());

            this.playerRepository.save(playerToSave);

            sb.append(String.format("Successfully imported Player %s %s - %s",
                    player.getFirstName(),
                    player.getLastName(),
                    player.getPosition()))
                    .append(System.lineSeparator());

        }


        return sb.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        LocalDate before = LocalDate.of(2003, 1, 1);
        LocalDate after = LocalDate.of(1995, 1, 1);

        StringBuilder sb = new StringBuilder();

        List<Player> players = playerRepository
                .findByBirthDateBetweenOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(after, before);

       players.forEach(el-> sb.append(String.format(
               "Player - %s %s\n" +
                       "\tPosition - %s\n" +
                       "\tTeam - %s\n" +
                       "\tStadium - %s\n",
               el.getFirstName(),
               el.getLastName(),
               el.getPosition(),
               el.getTeam().getName(),
               el.getTeam().getStadiumName())));

       return sb.toString();

    }
}
