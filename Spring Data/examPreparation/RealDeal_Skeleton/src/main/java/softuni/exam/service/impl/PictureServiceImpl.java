package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PictureImport;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private static String PICTURE_PATH = "src/main/resources/files/json/pictures.json";

    private CarRepository carRepository;

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtils validationUtils;


    private PictureRepository pictureRepository;


    public PictureServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils, PictureRepository pictureRepository) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURE_PATH));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder sb = new StringBuilder();

        String fileContent = this.readPicturesFromFile();

        List<PictureImport> list =
        Arrays.stream(gson.fromJson(fileContent, PictureImport[].class)).collect(Collectors.toList());

        for (PictureImport pictureImport : list) {
            if (!validationUtils.isValid(pictureImport))
            {
                sb.append("Invalid picture")
                        .append(System.lineSeparator());

                continue;
            }

            Picture pictureToSave = this.modelMapper.map(pictureImport, Picture.class);

            pictureToSave.setCar(carRepository.findById(pictureImport.getCar()).get());

            pictureRepository.save(pictureToSave);

            sb.append(String.format("Successfully import picture - %s",
                    pictureImport.getName()))
                    .append(System.lineSeparator());


        }

        return sb.toString().trim();
    }
}
