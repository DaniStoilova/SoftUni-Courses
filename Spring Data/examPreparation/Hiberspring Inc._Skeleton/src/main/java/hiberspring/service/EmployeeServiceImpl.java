package hiberspring.service;

import hiberspring.domain.dtos.EmployeeImport;
import hiberspring.domain.dtos.EmployeeWrapper;
import hiberspring.domain.dtos.ProductImport;
import hiberspring.domain.dtos.ProductWrapper;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.entities.Product;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.repository.EmployeeRepository;
import hiberspring.util.ValidationUtils;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static String EMPLOYEE_PATH = "src/main/resources/files/employees.xml";

  private EmployeeCardRepository employeeCardRepository;

    private BranchRepository branchRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeCardRepository employeeCardRepository, BranchRepository branchRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils, EmployeeRepository employeeRepository) {
        this.employeeCardRepository = employeeCardRepository;
        this.branchRepository = branchRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Boolean employeesAreImported() {
        return employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        List<EmployeeImport> employee = xmlParser.fromFile(EMPLOYEE_PATH, EmployeeWrapper.class).getEmployee();

        for (EmployeeImport employeeImport : employee) {

            Optional<EmployeeCard> number = employeeCardRepository.findFirstByNumber(employeeImport.getCard());

            Optional<Branch> name = branchRepository.findFirstByName(employeeImport.getBranch());


            if(!validationUtils.isValid(employeeImport) || number.isEmpty() || name.isEmpty()){

                sb.append("Error: Invalid data.").append(System.lineSeparator());

                continue;
            }

            Employee employeeToSave = this.modelMapper.map(employeeImport, Employee.class);

            employeeToSave.setCard(number.get());
            employeeToSave.setBranch(name.get());

            employeeRepository.save(employeeToSave);


            sb.append(String.format("Successfully imported Employee %s %s.",
                    employeeImport.getFirstName(),employeeImport.getLastName())).append(System.lineSeparator());

        }



        return sb.toString().trim();
    }


    @Override
    public String exportProductiveEmployees() {
        StringBuilder sb = new StringBuilder();

        List<Employee> all = employeeRepository.findAll();

       all.forEach(el->sb.append(String.format
               ("Name: %s\n" +
               "Position: %s\n" +
               "Card Number: %s\n" +
               "-------------------------\n",
                       el.getFirstName(),el.getPosition(),el.getCard().getNumber())));


        return sb.toString().trim();
    }
}
