package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImport;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private static String CAR_PATH = "src/main/resources/files/json/cars.json";

    private CarRepository carRepository;

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtils validationUtils;



    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CAR_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readCarsFileContent();

        List<CarImport> collect = Arrays.stream
                (gson.fromJson(fileContent, CarImport[].class)).collect(Collectors.toList());

        for (CarImport carImport : collect) {

            if(!validationUtils.isValid(carImport)){
                sb.append("Invalid car")
                        .append(System.lineSeparator());

                continue;
            }
            Car carToSave = this.modelMapper.map(carImport, Car.class);

            carRepository.save(carToSave);
            sb.append(String.format("Successfully imported car - %s - %s",
                    carImport.getMake(),
                    carImport.getModel()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();

        carRepository.findAll()
               .forEach(
                        el-> sb.append(String.format(
                                "Car make - %s, model - %s\n" +
                                "\tKilometers - %d\n" +
                                "\tRegistered on - %s\n" +
                                "\tNumber of pictures - %d\n",
                                el.getMake(),
                                el.getModel(),
                                el.getKilometers(),
                                el.getRegisteredOn(),
                                el.getPictures().size())).append(System.lineSeparator()));

        return sb.toString().trim();
    }


}
