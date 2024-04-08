package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImport;
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

    private ModelMapper modelmapper;

    private ValidationUtils validationUtils;



    public TownServiceImpl(TownRepository townRepository, Gson gson, ModelMapper modelmapper, ValidationUtils validationUtils) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelmapper = modelmapper;
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

        List<TownImport> townImports = Arrays.stream(gson.fromJson(fileContent, TownImport[].class)).collect(Collectors.toList());

        for (TownImport town : townImports) {

            if (!validationUtils.isValid(town) ||
            townRepository.findFirstByName(town.getName()).isPresent()){
                sb.append("Invalid Town")
                        .append(System.lineSeparator());
                continue;
            }

            Town townToSave = this.modelmapper.map(town, Town.class);

            townRepository.save(townToSave);

            sb.append(String.format("Successfully imported Town %s - %d",
                    town.getName(),
                    town.getPopulation()))
                    .append(System.lineSeparator());

        }


        return sb.toString().trim();
    }
}
