package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicImportModel;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class MechanicsServiceImpl implements MechanicsService {

    private static String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";

    private final MechanicsRepository mechanicsRepository;
    private ValidationUtils validationUtils;
    private ModelMapper modelMapper;
    private Gson gson;


    @Autowired
    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, ValidationUtils validationUtils, ModelMapper modelMapper, Gson gson) {
        this.mechanicsRepository = mechanicsRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {

        return mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
//        InputStream stream = this.getClass().getResourceAsStream(MECHANICS_FILE_PATH);
//
//        byte[] bytes = stream.readAllBytes();
//
//        return new String(bytes);

        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder sb = new StringBuilder();

        String file = this.readMechanicsFromFile();

        MechanicImportModel[] mechanicsWrapper = gson.fromJson(file, MechanicImportModel[].class);

        for (MechanicImportModel mechanics : mechanicsWrapper) {

            if (this.mechanicsRepository.findMechanicByEmail(mechanics.getEmail()).isPresent() ||
            !this.validationUtils.isValid(mechanics)){
                sb.append("Invalid mechanic")
                        .append(System.lineSeparator());
                continue;
            }

            Mechanic mechanic = this.modelMapper.map(mechanics, Mechanic.class);

            this.mechanicsRepository.save(mechanic);

            sb.append(String.format("Successfully imported mechanic %s %s",
                    mechanics.getFirstName(),mechanics.getLastName()))
                    .append(System.lineSeparator());


        }

        return sb.toString().trim();
    }
}
