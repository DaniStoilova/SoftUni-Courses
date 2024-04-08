package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstroImport;
import softuni.exam.models.dto.AstroWrapper;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private static String ASTRO_PATH = "src/main/resources/files/xml/astronomers.xml";

    private AstronomerRepository astronomerRepository;

    private StarRepository starRepository;

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtils validationUtils;

    private XmlParser xmlParser;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils, XmlParser xmlParser) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRO_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        List<AstroImport> astronomer = xmlParser.fromFile(ASTRO_PATH, AstroWrapper.class).getAstronomer();

        for (AstroImport astroImport : astronomer) {

            Optional<Star> byId = starRepository.findById(astroImport.getObservingStar());

            if (!validationUtils.isValid(astroImport)
            || astronomerRepository.findByFirstNameAndLastName(astroImport.getFirstName(), astroImport.getLastName()).isPresent()
            || byId.isEmpty()){
                sb.append("Invalid astronomer").append(System.lineSeparator());

                continue;
            }

            Astronomer astro = modelMapper.map(astroImport, Astronomer.class);

             astro.setObservingStar(byId.get());

             astronomerRepository.save(astro);

             sb.append(String.format("Successfully imported astronomer %s %s - %.2f",
                            astroImport.getFirstName(),
                            astroImport.getLastName(),
                            astroImport.getAverageObservationHours())).append(System.lineSeparator());


        }


//        xmlParser
//                .fromFile(ASTRO_PATH, AstroWrapper.class)
//                .getAstronomer()
//                .stream()
//                .filter(astroImport -> {
//                    boolean isValid = validationUtils.isValid(astroImport);
//
//                    Optional<Star> byId = starRepository.findById(astroImport.getObservingStar());
//
//                    boolean doesntExist = astronomerRepository
//             .findByFirstNameAndLastName(astroImport.getFirstName(), astroImport.getLastName()).isEmpty();
//                    if (!doesntExist || byId.isEmpty()){
//                        isValid = false;
//                    }
//
//                    sb.append(isValid
//                                    ? String.format("Successfully imported astronomer %s %s - %.2f",
//                            astroImport.getFirstName(),
//                            astroImport.getLastName(),
//                            astroImport.getAverageObservationHours())
//                                    : "Invalid astronomer")
//                            .append(System.lineSeparator());
//
//                    return isValid;
//                })
//                .map(astroImport -> {
//                    Astronomer astronomer = modelMapper.map(astroImport, Astronomer.class);
//
//                    Optional<Star> byId = starRepository.findById(astroImport.getObservingStar());
//
//                    astronomer.setObservingStar(byId.get());
//
//                    return astronomer;
//                })
//                .forEach(astronomerRepository::save);


        return sb.toString().trim();
    }
}
