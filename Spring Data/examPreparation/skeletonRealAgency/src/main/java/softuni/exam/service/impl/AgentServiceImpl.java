package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImport;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {

    private static String AGENT_PATH = "src/main/resources/files/json/agents.json";

    private final AgentRepository agentRepository;

    private Gson gson;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;




    public AgentServiceImpl(AgentRepository agentRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.agentRepository = agentRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENT_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder sb = new StringBuilder();

        String file = this.readAgentsFromFile();

        List<AgentImport> agentImports = Arrays.stream(gson.fromJson(file, AgentImport[].class)).collect(Collectors.toList());

        for (AgentImport agentImport : agentImports) {

        if(!validationUtils.isValid(agentImport) || this.agentRepository.findFirstByFirstName(agentImport.getFirstName()).isPresent()){

            sb.append("Invalid agent")
                    .append(System.lineSeparator());

            continue;

        }

            Agent agent = this.modelMapper.map(agentImport, Agent.class);

            this.agentRepository.save(agent);

            sb.append(String.format("Successfully imported agent - %s %s",
                    agent.getFirstName(),
                    agent.getLastName()))
                    .append(System.lineSeparator());


        }

        return sb.toString();
    }
}
