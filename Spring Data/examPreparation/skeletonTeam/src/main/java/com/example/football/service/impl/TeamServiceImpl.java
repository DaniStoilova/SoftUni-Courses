package com.example.football.service.impl;

import com.example.football.models.dto.TeamImport;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtils;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private static String TEAM_PATH = "src/main/resources/files/json/teams.json";

    private TeamRepository teamRepository;

    private TownRepository townRepository;

    private TownService townService;

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtils validationUtils;

    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, TownService townService, ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
    }


    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAM_PATH));
    }

    @Override
    public String importTeams() throws IOException {

        StringBuilder sb = new StringBuilder();

        String fileContent = this.readTeamsFileContent();

        List<TeamImport> collect =
                Arrays.stream(gson.fromJson(fileContent, TeamImport[].class)).collect(Collectors.toList());


        for (TeamImport team : collect) {

            if (!validationUtils.isValid(team) ||
            this.teamRepository.findFirstByName(team.getName()).isPresent()
            ){

                sb.append("Invalid Team")
                        .append(System.lineSeparator());

                continue;
            }

            Team teamToSave = this.modelMapper.map(team,Team.class);

            Optional<Town> town = this.townRepository.findFirstByName(team.getTownName());

            teamToSave.setTown(town.get());

            this.teamRepository.save(teamToSave);

            sb.append(String.format("Successfully imported Team %s - %d",
                    team.getName(),
                    team.getFanBase()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
