package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.domain.dtos.EmployeeCardImport;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private static String EM_CARD_PATH = "src/main/resources/files/employee-cards.json";

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtils validationUtils;

    private EmployeeCardRepository employeeCardRepository;

    public EmployeeCardServiceImpl(ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils, EmployeeCardRepository employeeCardRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.employeeCardRepository = employeeCardRepository;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Path.of(EM_CARD_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readEmployeeCardsJsonFile();

        List<EmployeeCardImport> collect = Arrays.stream(gson.fromJson(fileContent, EmployeeCardImport[].class)).collect(Collectors.toList());

        for (EmployeeCardImport employeeCardImport : collect) {

            if (!validationUtils.isValid(employeeCardImport) ||
            employeeCardRepository.findFirstByNumber(employeeCardImport.getNumber()).isPresent()){

                sb.append("Error: Invalid data.").append(System.lineSeparator());
                continue;
            }
            EmployeeCard card = this.modelMapper.map(employeeCardImport, EmployeeCard.class);

            employeeCardRepository.save(card);

            sb.append(String.format("Successfully imported Employee Card %s.",
                    employeeCardImport.getNumber())).append(System.lineSeparator());

        }


        return sb.toString().trim();
    }
}
