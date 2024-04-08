package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.TeamImport;
import softuni.exam.domain.dto.TeamWrapper;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private static String TEAM_PATH = "src/main/resources/files/xml/teams.xml";

    private PictureRepository pictureRepository;

    private TeamRepository teamRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    public TeamServiceImpl(PictureRepository pictureRepository, TeamRepository teamRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils) {
        this.pictureRepository = pictureRepository;
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }

    @Override
    public String importTeams() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        List<TeamImport> team = xmlParser.fromFile(TEAM_PATH, TeamWrapper.class).getTeam();

        for (TeamImport teamImport : team) {

            if (!validationUtils.isValid(teamImport) ||
                    pictureRepository.findFirstByUrl(teamImport.getPicture().getUrl()).isEmpty()){

                sb.append("Invalid team")
                        .append(System.lineSeparator());

                continue;

            }

            Team teamToSave = this.modelMapper.map(teamImport, Team.class);



            teamToSave.setPicture(pictureRepository.findFirstByUrl(teamImport.getPicture().getUrl()).get());

            teamRepository.save(teamToSave);

            sb.append(String.format("Successfully imported - %s",
                  teamImport.getName())).append(System.lineSeparator());

        }

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {

        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {

    return Files.readString(Path.of(TEAM_PATH));
    }
}
