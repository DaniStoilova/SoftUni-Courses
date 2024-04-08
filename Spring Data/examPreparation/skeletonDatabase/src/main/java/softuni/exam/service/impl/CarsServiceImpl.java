package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImport;
import softuni.exam.models.dto.CarImportWrapper;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {


   private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final CarsRepository carsRepository;

    private XmlParser xmlParser;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;



    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {

    return carsRepository.count() > 0 ;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        List<CarImport> cars = this.xmlParser.fromFile(CARS_FILE_PATH,
                CarImportWrapper.class).getCars();


            for (CarImport car : cars) {

                if (!validationUtils.isValid(car) ||
                        carsRepository.findFirstByPlateNumber(car.getPlateNumber()).isPresent()){
                    sb.append("Invalid car")
                            .append(System.lineSeparator());
                    continue;

                }

                this.carsRepository.save(this.modelMapper.map(car, Car.class));

                sb.append(String.format("Successfully imported car %s - %s",
                                car.getCarMake(),car.getCarModel()))
                        .append(System.lineSeparator());

            }

        return sb.toString();
    }
}
