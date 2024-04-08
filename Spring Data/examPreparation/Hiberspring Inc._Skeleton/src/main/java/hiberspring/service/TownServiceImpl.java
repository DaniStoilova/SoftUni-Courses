package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.domain.dtos.TownImport;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService{

    private static String TOWN_PATH = "src/main/resources/files/towns.json";

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
    public Boolean townsAreImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return Files.readString(Path.of(TOWN_PATH));
    }

    @Override
    public String importTowns(String townsFileContent) throws IOException {

        StringBuilder sb = new StringBuilder();

        String fileContent = this.readTownsJsonFile();

        List<TownImport> collect = Arrays.stream(gson.fromJson(fileContent, TownImport[].class)).collect(Collectors.toList());

        for (TownImport townImport : collect) {



            if(!validationUtils.isValid(townImport)){
                sb.append("Error: Invalid data.").append(System.lineSeparator());

                continue;
            }

            Town townToSave = this.modelMapper.map(townImport, Town.class);



            townRepository.save(townToSave);

            sb.append(String.format("Successfully imported Town %s.",
                    townImport.getName())).append(System.lineSeparator());


        }

        return sb.toString().trim();
    }
}
