package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartsImportModel;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PartsServiceImpl implements PartsService {

    private static String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";

    private final PartsRepository partsRepository;

    private ValidationUtils validationUtils;

    private ModelMapper modelMapper;


    private Gson gson;

    @Autowired
    public PartsServiceImpl(PartsRepository partsRepository, ValidationUtils validationUtils, ModelMapper modelMapper, Gson gson) {
        this.partsRepository = partsRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {

        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
//        InputStream stream = this.getClass().getResourceAsStream(PARTS_FILE_PATH);
//
//        byte[] bytes = stream.readAllBytes();
//
//        return new String(bytes);

        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {

        StringBuilder sb = new StringBuilder();

//        String file = this.readPartsFileContent();
//
//        PartsImportModel[] partsWrapper = gson.fromJson(file, PartsImportModel[].class);

        List<PartsImportModel> partsWrapper = Arrays.stream
                        (gson.fromJson(readPartsFileContent(), PartsImportModel[].class))
                .collect(Collectors.toList());

        for (PartsImportModel parts : partsWrapper) {

            if (this.partsRepository.findFirstByPartName(parts.getPartName()).isPresent() ||
                    !this.validationUtils.isValid(parts)) {
                sb.append("Invalid part");
                sb.append(System.lineSeparator());
                continue;
            }

            Part part = this.modelMapper.map(parts, Part.class);

            this.partsRepository.save(part);

            sb.append(String.format("Successfully imported part %s - %s",
                    parts.getPartName(), parts.getPrice()));

            sb.append(System.lineSeparator());

        }


        return sb.toString().trim();
    }
}
