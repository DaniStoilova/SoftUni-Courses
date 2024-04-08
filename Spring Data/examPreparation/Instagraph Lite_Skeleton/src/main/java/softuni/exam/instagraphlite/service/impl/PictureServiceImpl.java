package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureImport;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private static String PICTURE_PATH = "src/main/resources/files/pictures.json";

    private PictureRepository pictureRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private Gson gson;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidationUtils validationUtils, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readFromFileContent();

        List<PictureImport> list = Arrays.stream(gson.fromJson(fileContent, PictureImport[].class)).collect(Collectors.toList());


        for (PictureImport pictureImport : list) {


            if (!validationUtils.isValid(pictureImport) || pictureRepository.findFirstByPath(pictureImport.getPath()).isPresent()){
                sb.append("Invalid Picture")
                        .append(System.lineSeparator());

                continue;
            }

            Picture picture = this.modelMapper.map(pictureImport, Picture.class);

            pictureRepository.save(picture);

            sb.append(String.format("Successfully imported Picture, with size %.2f",
                    pictureImport.getSize()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public String exportPictures() {

        StringBuilder sb = new StringBuilder();

        List<Picture> all = this.pictureRepository.findAllBySizeGreaterThanOrderBySizeAsc(30000.0);

        all.forEach(el-> sb.append(String.format("%.2f – %s%n",
                el.getSize(),
                el.getPath())));

        return sb.toString().trim();
    }
}
