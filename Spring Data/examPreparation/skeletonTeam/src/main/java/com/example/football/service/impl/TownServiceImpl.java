package com.example.football.service.impl;

import com.example.football.models.dto.TownImport;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
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
import java.util.stream.Collectors;


@Service
public class TownServiceImpl implements TownService {

    private static String TOWN_PATH = "src/main/resources/files/json/towns.json";

    private TownRepository townRepository;

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtils validationUtils;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
    }


    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readTownsFileContent();

        List<TownImport> collect =
                Arrays.stream(gson.fromJson(fileContent, TownImport[].class)).collect(Collectors.toList());


        for (TownImport town : collect) {

            if (!validationUtils.isValid(town) ||
            this.townRepository.findFirstByName(town.getName()).isPresent()){
                sb.append("Invalid Town")
                        .append(System.lineSeparator());

                continue;
            }

            Town townToSave = this.modelMapper.map(town, Town.class);

            this.townRepository.save(townToSave);

            sb.append(String.format("Successfully imported Town %s - %d",
                    town.getName(),
                    town.getPopulation()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }


}
