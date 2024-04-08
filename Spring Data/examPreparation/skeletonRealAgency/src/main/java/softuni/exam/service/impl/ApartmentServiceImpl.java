package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentImportDto;
import softuni.exam.models.dto.ApartmentWrapper;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@Service
public class ApartmentServiceImpl implements ApartmentService {

    private static String APARTMENT_PATH = "src/main/resources/files/xml/apartments.xml";

    private ApartmentRepository apartmentRepository;

   private TownRepository townRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private XmlParser xmlParser;


    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownRepository townRepository, ModelMapper modelMapper, ValidationUtils validationUtils, XmlParser xmlParser) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;

    }


    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENT_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

//      List<ApartmentImportDto> apartments =
//              this.xmlParser.fromFile(APARTMENT_PATH, ApartmentWrapper.class)
//                      .getApartments();
//
//        for (ApartmentImportDto apartment : apartments) {
//
//
//            boolean empty = apartmentRepository.findApartmentByAreaAndTown
//          (apartment.getArea(), townRepository.findTownByTownName(apartment.getTown()))
//                    .isEmpty();
//
//            if (!validationUtils.isValid(apartment)){
//                sb.append("Invalid apartment")
//                        .append(System.lineSeparator());
//                continue;
//            }
//
//            Apartment map = this.modelMapper.map(apartment, Apartment.class);
//
//            Town townByName = townRepository.findTownByTownName(apartment.getTown());
//            apartment.setTown(townByName.getTownName());
//           // apartment.setTown(String.valueOf(townByName));
//
//            apartmentRepository.save(map);
//
//            sb.append(String.format("Successfully import apartment %s - %.2f",
//                                   apartment.getApartmentType(), apartment.getArea()))
//                    .append(System.lineSeparator());
//
//        }

        xmlParser
                .fromFile(APARTMENT_PATH, ApartmentWrapper.class)
                .getApartments()
                .stream()
                .filter(apartment -> {
                    boolean isValid = validationUtils.isValid(apartment);

 boolean doesntExist = apartmentRepository.findApartmentByAreaAndTown(apartment.getArea(),
                                    townRepository.findTownByTownName(apartment.getTown()))
                            .isEmpty();
                    if (!doesntExist){
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format("Successfully import apartment %s - %.2f",
                                    apartment.getApartmentType(), apartment.getArea())
                                    : "Invalid apartment")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(apartmentSeedDto -> {
                    Apartment apartment = modelMapper.map(apartmentSeedDto, Apartment.class);
                    Town townByName = townRepository.findTownByTownName(apartmentSeedDto.getTown());
                    apartment.setTown(townByName);

                    return apartment;
                })
                .forEach(apartmentRepository::save);


        return sb.toString();
    }
}
