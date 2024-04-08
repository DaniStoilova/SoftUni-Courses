package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PictureImport;
import softuni.exam.domain.dto.PictureWrapper;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private static String PICTURE_PATH = "src/main/resources/files/xml/pictures.xml";

    private PictureRepository pictureRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }

    @Override
    public String importPictures() throws JAXBException {
       StringBuilder sb = new StringBuilder();

        List<PictureImport> picture = xmlParser.fromFile(PICTURE_PATH, PictureWrapper.class).getPicture();

        for (PictureImport pictureImport : picture) {

            if (!validationUtils.isValid(pictureImport)){

                sb.append("Invalid picture")
                        .append(System.lineSeparator());

                continue;

            }

            Picture pictureToSave = this.modelMapper.map(pictureImport, Picture.class);

            pictureRepository.save(pictureToSave);

            sb.append(String.format("Successfully imported picture - %s",
                    pictureImport.getUrl())).append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {

        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {

        return Files.readString(Path.of(PICTURE_PATH));
    }

}
