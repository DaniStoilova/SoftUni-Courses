package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarImport;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarServiceImpl implements StarService {

    private static String STAR_PATH = "src/main/resources/files/json/stars.json";

    private StarRepository starRepository;

    private ConstellationRepository constellationRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private Gson gson;

    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, ModelMapper modelMapper, ValidationUtils validationUtils, Gson gson) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STAR_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readStarsFileContent();

        List<StarImport> collect = Arrays.stream(gson.fromJson(fileContent, StarImport[].class)).collect(Collectors.toList());

        for (StarImport starImport : collect) {

            if (!validationUtils.isValid(starImport) ||
            starRepository.findFirstByName(starImport.getName()).isPresent()){
                sb.append("Invalid star").append(System.lineSeparator());

                continue;

            }

            Star star = this.modelMapper.map(starImport, Star.class);

            Constellation constellation = this.constellationRepository.findById(starImport.getConstellation()).get();

             star.setConstellation(constellation);

            starRepository.save(star);

            sb.append(String.format("Successfully imported star %s - %.2f light years",
                    starImport.getName(),starImport.getLightYears())).append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public String exportStars() {

        StringBuilder sb = new StringBuilder();

        List<Star> all = starRepository.findAllByStarTypeAndObserversEmptyOrderByLightYears(StarType.RED_GIANT);

        all.forEach(el->
                sb.append(String.format("Star: %s\n" +
                                "   *Distance: %.2f light years\n" +
                                "   **Description: %s\n" +
                                "   ***Constellation: %s\n",
                        el.getName(),
                        el.getLightYears(),
                        el.getDescription(),
                        el.getConstellation().getName())));


        return sb.toString().trim();
    }
}
