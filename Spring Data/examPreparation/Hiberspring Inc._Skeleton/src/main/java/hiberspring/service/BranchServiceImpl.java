package hiberspring.service;

import com.google.gson.Gson;
import hiberspring.domain.dtos.BranchImport;
import hiberspring.domain.dtos.TownImport;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.TownRepository;
import hiberspring.util.ValidationUtils;
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
public class BranchServiceImpl implements BranchService {


    private static String BRANCH_PATH = "src/main/resources/files/branches.json";

    private TownRepository townRepository;

    private BranchRepository branchRepository;

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtils validationUtils;

    public BranchServiceImpl(TownRepository townRepository, BranchRepository branchRepository, ModelMapper modelMapper, Gson gson, ValidationUtils validationUtils) {
        this.townRepository = townRepository;
        this.branchRepository = branchRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
    }

    @Override
    public Boolean branchesAreImported() {
        return branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Path.of(BRANCH_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readBranchesJsonFile();

        List<BranchImport> collect = Arrays.stream(gson.fromJson(fileContent, BranchImport[].class)).collect(Collectors.toList());

        for (BranchImport branchImport : collect) {

            Optional<Town> name = townRepository.findFirstByName(branchImport.getTown());

            if(!validationUtils.isValid(branchImport)){
                sb.append("Error: Invalid data.").append(System.lineSeparator());

                continue;
            }

            Branch branch = this.modelMapper.map(branchImport, Branch.class);

            branch.setTown(name.get());


            branchRepository.save(branch);

            sb.append(String.format("Successfully imported Branch %s.",
                   branchImport.getName())).append(System.lineSeparator());


        }

        return sb.toString().trim();
    }
}
