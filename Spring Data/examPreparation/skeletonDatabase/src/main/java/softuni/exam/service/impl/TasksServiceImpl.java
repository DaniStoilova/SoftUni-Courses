package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskCoupeDTO;
import softuni.exam.models.dto.TaskImportModel;
import softuni.exam.models.dto.TaskWrapper;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";
    
    private final TasksRepository tasksRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private XmlParser xmlParser;

    private MechanicsRepository mechanicsRepository;

    private PartsRepository partsRepository;

    private CarsRepository carsRepository;

    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepository, ModelMapper modelMapper, ValidationUtils validationUtils, XmlParser xmlParser, MechanicsRepository mechanicsRepository, PartsRepository partsRepository, CarsRepository carsRepository) {
        this.tasksRepository = tasksRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.carsRepository = carsRepository;
    }

    @Override
    public boolean areImported() {

        return tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        List<TaskImportModel> tasks = this.xmlParser.fromFile(TASKS_FILE_PATH, TaskWrapper.class).getTasks();

        for (TaskImportModel task : tasks) {
            Optional<Mechanic> firstByFirstName = this.mechanicsRepository.findFirstByFirstName(task.getMechanic().getFirstName());
            Optional<Car> carById = this.carsRepository.findById(task.getCar().getId());
            Optional<Part> partById = this.partsRepository.findById(task.getPart().getId());

            if (firstByFirstName.isEmpty() || carById.isEmpty() || partById.isEmpty() || !validationUtils.isValid(task)
            ) {

                sb.append("Invalid task")
                        .append(System.lineSeparator());
                continue;
            }

            Task task1 = this.modelMapper.map(task, Task.class);
            task1.setCar(carById.get());
            task1.setMechanic(firstByFirstName.get());
            task1.setPart(partById.get());

            this.tasksRepository.save(task1);
            sb.append(String.format("Successfully imported task %.2f",
                            task1.getPrice()))
                    .append(System.lineSeparator());

        }


        return sb.toString();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {

        StringBuilder sb = new StringBuilder();



//        List<TaskCoupeDTO> collect = this.tasksRepository.findAllByCar_CarTypeOrderByPriceDesc(CarType.coupe)
//                .stream().map(task -> this.modelMapper.map(task, TaskCoupeDTO.class)).collect(Collectors.toList());
//
//        collect.forEach(el-> sb.append(String.format("Car %s %s with %skm\n" +
//                      "-Mechanic: %s %s - task №%d:\n" +
//                      " --Engine: %.1f\n" +
//                      "---Price: %.2f$\n",
//                      el.getCar().getCarMake(),
//                      el.getCar().getCarModel(),
//                      el.getCar().getKilometers(),
//                      el.getMechanic().getFirstName(),
//                      el.getMechanic().getLastName(),
//                      el.getId(),
//                      el.getCar().getEngine(),
//                      el.getPrice())));

        List<Task> all = this.tasksRepository.findAllByCar_CarTypeOrderByPriceDesc(CarType.coupe);
        all.forEach(el-> sb.append(String.format("Car %s %s with %skm\n" +
                        "-Mechanic: %s %s - task №%d:\n" +
                        " --Engine: %.1f\n" +
                        "---Price: %.2f$\n",
                el.getCar().getCarMake(),
                el.getCar().getCarModel(),
                el.getCar().getKilometers(),
                el.getMechanic().getFirstName(),
                el.getMechanic().getLastName(),
                el.getId(),
                el.getCar().getEngine(),
                el.getPrice())));

        return sb.toString().trim();

    }
}
