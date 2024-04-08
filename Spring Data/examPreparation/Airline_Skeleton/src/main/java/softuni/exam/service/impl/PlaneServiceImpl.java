package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneImport;
import softuni.exam.models.dto.PlaneWrapper;
import softuni.exam.models.entity.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {




    private static String PLANE_PATH = "src/main/resources/files/xml/planes.xml";
    private PlaneRepository planeRepository;


    private XmlParser xmlParser;

    private ModelMapper modelmapper;

    private ValidationUtils validationUtils;

    public PlaneServiceImpl(PlaneRepository planeRepository, XmlParser xmlParser, ModelMapper modelmapper, ValidationUtils validationUtils) {
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.modelmapper = modelmapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        List<PlaneImport> plane = xmlParser.fromFile(PLANE_PATH, PlaneWrapper.class).getPlane();

        for (PlaneImport planeImport : plane) {


            if (!validationUtils.isValid(planeImport)){
                sb.append("Invalid Plane")
                        .append(System.lineSeparator());

                continue;
            }

            Plane planeToSave = this.modelmapper.map(planeImport, Plane.class);

            planeRepository.save(planeToSave);

            sb.append(String.format("Successfully imported Plane %s",
                    planeImport.getRegisterNumber())).append(System.lineSeparator());

        }


        return sb.toString().trim();
    }
}
