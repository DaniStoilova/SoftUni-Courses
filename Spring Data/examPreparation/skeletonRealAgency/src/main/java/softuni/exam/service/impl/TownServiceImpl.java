package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImport;
import softuni.exam.models.dto.TownImport;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtils;

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
    private Gson gson;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;


    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
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

        String file = this.readTownsFileContent();

        List<TownImport> townImports = Arrays.stream(gson.fromJson(file, TownImport[].class)).collect(Collectors.toList());

        for (TownImport townImport : townImports) {

            if(!validationUtils.isValid(townImport) || townRepository.findFirstByTownName(
                    townImport.getTownName()).isPresent() ){

                sb.append("Invalid town")
                        .append(System.lineSeparator());

                continue;

            }

            Town town = this.modelMapper.map(townImport, Town.class);

            this.townRepository.save(town);

            sb.append(String.format("Successfully imported town %s - %d",
                    town.getTownName(),
                    town.getPopulation()))
                    .append(System.lineSeparator());

        }

        return sb.toString();
    }

}
