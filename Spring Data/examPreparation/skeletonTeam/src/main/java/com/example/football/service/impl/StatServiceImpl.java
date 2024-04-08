package com.example.football.service.impl;

import com.example.football.models.dto.StatImport;
import com.example.football.models.dto.StatWrapper;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtils;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class StatServiceImpl implements StatService {

    private static String STAT_PATH = "src/main/resources/files/xml/stats.xml";

    private StatRepository statRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }


    @Override
    public boolean areImported() {
        return statRepository.count() > 0 ;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STAT_PATH));
    }

    @Override
    public String importStats() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        List<StatImport> stats = xmlParser.fromFile(STAT_PATH, StatWrapper.class).getStats();

        for (StatImport stat : stats) {

            if (!validationUtils.isValid(stat) ||
                    statRepository.findByPassingAndShootingAndEndurance(
                            stat.getPassing(),
                            stat.getShooting(),
                            stat.getEndurance()).isPresent()){
                sb.append("Invalid Stat")
                        .append(System.lineSeparator());
                continue;
            }


            Stat statToSave = this.modelMapper.map(stat, Stat.class);

            this.statRepository.save(statToSave);

            sb.append(String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                    stat.getShooting(),
                    stat.getPassing(),
                    stat.getEndurance()))
                    .append(System.lineSeparator());

        }

        return sb.toString().trim();
    }
}
