package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerImport;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {


    private static String PASSENGER_PATH = "src/main/resources/files/json/passengers.json";

    private PassengerRepository passengerRepository;

    private TownRepository townRepository;

    private Gson gson;

    private ModelMapper modelmapper;

    private ValidationUtils validationUtils;


    public PassengerServiceImpl(PassengerRepository passengerRepository, TownRepository townRepository, Gson gson, ModelMapper modelmapper, ValidationUtils validationUtils) {
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelmapper = modelmapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGER_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readPassengersFileContent();

        List<PassengerImport> passengerImportList = Arrays.stream(gson.fromJson(fileContent, PassengerImport[].class)).collect(Collectors.toList());

        for (PassengerImport passenger : passengerImportList) {
            if (!validationUtils.isValid(passenger) ||
            this.townRepository.findFirstByName(passenger.getTown()).isEmpty()){
                sb.append("Invalid Passenger")
                        .append(System.lineSeparator());

                continue;
            }

            Passenger passengerToSave = this.modelmapper.map(passenger, Passenger.class);
            Optional<Town> town = this.townRepository.findFirstByName(passenger.getTown());

            passengerToSave.setTown(town.get());

            passengerRepository.save(passengerToSave);

            sb.append(String.format("Successfully imported Passenger %s - %s",
                    passenger.getLastName(),
                    passenger.getEmail()))
                    .append(System.lineSeparator());

        }


        return sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();

        this.passengerRepository.findAll()
                .forEach(el->
                sb.append(String.format("Passenger %s  %s\n" +
                        "\tEmail - %s\n" +
                        "\tPhone - %s\n" +
                        "\tNumber of tickets - %d\n",
                        el.getFirstName(),
                        el.getLastName(),
                        el.getEmail(),
                        el.getPhoneNumber(),
                        el.getTickets().size())));


        return sb.toString().trim();
    }
}
