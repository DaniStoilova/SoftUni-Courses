package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImport;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private static String CONST_PATH = "src/main/resources/files/json/constellations.json";
    private ConstellationRepository constellationRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private Gson gson;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ModelMapper modelMapper, ValidationUtils validationUtils, Gson gson) {
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONST_PATH));
    }

    @Override
    public String importConstellations() throws IOException {

        StringBuilder sb = new StringBuilder();

        String fileContent = this.readConstellationsFromFile();

        List<ConstellationImport> collect = Arrays.stream(gson.fromJson(fileContent, ConstellationImport[].class)).collect(Collectors.toList());

        for (ConstellationImport constellationImport : collect) {


            if (!validationUtils.isValid(constellationImport) ||
            constellationRepository.findFirstByName(constellationImport.getName()).isPresent()){

                sb.append("Invalid constellation").append(System.lineSeparator());

                continue;

            }
            Constellation constellationToSave = this.modelMapper.map(constellationImport, Constellation.class);

            constellationRepository.save(constellationToSave);

            sb.append(String.format("Successfully imported constellation %s - %s",
                    constellationImport.getName(),
                    constellationImport.getDescription())).append(System.lineSeparator());

        }


        return sb.toString().trim();
    }
}
