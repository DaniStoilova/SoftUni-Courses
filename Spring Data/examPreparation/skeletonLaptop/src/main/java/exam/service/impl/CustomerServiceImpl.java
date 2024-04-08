package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerImport;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static String CUSTOMER_PATH = "src/main/resources/files/json/customers.json";

    private CustomerRepository customerRepository;

    private TownRepository townRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private Gson gson;

    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository, ModelMapper modelMapper, ValidationUtils validationUtils, Gson gson) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMER_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readCustomersFileContent();

        List<CustomerImport> collect = Arrays.stream(gson.fromJson(fileContent, CustomerImport[].class)).collect(Collectors.toList());

        for (CustomerImport customers : collect) {

            if(!validationUtils.isValid(customers) ||
            customerRepository.findFirstByEmail(customers.getEmail()).isPresent()){

                sb.append("Invalid Customer")
                        .append(System.lineSeparator());
                continue;
            }

            Customer customerToSave = this.modelMapper.map(customers, Customer.class);

            Optional<Town> town = this.townRepository.findFirstByName(customers.getTown().getName());

            customerToSave.setTown(town.get());

            customerRepository.save(customerToSave);

            sb.append(String.format("Successfully imported Customer %s %s - %s",
                    customers.getFirstName(),
                    customers.getLastName(),
                    customers.getEmail()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
