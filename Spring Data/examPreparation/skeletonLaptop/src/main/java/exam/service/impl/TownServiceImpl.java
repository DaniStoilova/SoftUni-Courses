package exam.service.impl;

import exam.model.dto.TownImport;
import exam.model.dto.TownWrapper;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtils;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class TownServiceImpl implements TownService {

    private static String TOWN_PATH = "src/main/resources/files/xml/towns.xml";

    private TownRepository townRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private XmlParser xmlParser;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, ValidationUtils validationUtils, XmlParser xmlParser) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        List<TownImport> towns = xmlParser.fromFile(TOWN_PATH, TownWrapper.class).getTowns();

        for (TownImport town : towns) {

        if (!validationUtils.isValid(town)||
        this.townRepository.findFirstByName(town.getName()).isPresent()){
            sb.append("Invalid town")
                    .append(System.lineSeparator());

            continue;
        }

            Town townToSave = this.modelMapper.map(town, Town.class);

                this.townRepository.save(townToSave);

                sb.append(String.format("Successfully imported Town %s",
                        town.getName())).append(System.lineSeparator());


        }

        return sb.toString().trim();
    }
}
