package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.Dto;
import softuni.exam.instagraphlite.models.dto.UserImport;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static String USER_PATH = "src/main/resources/files/users.json";

    private UserRepository userRepository;

    private PictureRepository pictureRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private Gson gson;

    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, ModelMapper modelMapper, ValidationUtils validationUtils, Gson gson) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readFromFileContent();

        List<UserImport> list = Arrays.stream(gson.fromJson(fileContent, UserImport[].class)).collect(Collectors.toList());


        for (UserImport userImport : list) {

            if (!validationUtils.isValid(userImport) ||
         pictureRepository.findFirstByPath(userImport.getProfilePicture()).isEmpty()){
                sb.append("Invalid User")
                        .append(System.lineSeparator());

                continue;
            }

            User user = this.modelMapper.map(userImport, User.class);

            Optional<Picture> path = this.pictureRepository.findFirstByPath(userImport.getProfilePicture());

            user.setProfilePicture(path.get());

            userRepository.save(user);

            sb.append(String.format("Successfully imported User: %s",
                    userImport.getUsername()))
                    .append(System.lineSeparator());


        }

        return sb.toString().trim();
    }

    @Override
    public String exportUsersWithTheirPosts() {


     return userRepository.findAllByPost().stream()
              .map(task -> this.modelMapper.map(task, Dto.class))
                .map(Dto::toString)
                .collect(Collectors.joining())
                .trim();



    }
}
