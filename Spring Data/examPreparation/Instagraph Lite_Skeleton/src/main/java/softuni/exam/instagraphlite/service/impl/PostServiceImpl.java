package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostImportDto;
import softuni.exam.instagraphlite.models.dto.PostWrapper;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtils;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {


    private static String POST_PATH = "src/main/resources/files/posts.xml";

    private PostRepository postRepository;

    private PictureRepository pictureRepository;

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;


    private XmlParser xmlParser;

    public PostServiceImpl(PostRepository postRepository, PictureRepository pictureRepository, UserRepository userRepository, ModelMapper modelMapper, ValidationUtils validationUtils, XmlParser xmlParser) {
        this.postRepository = postRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<PostImportDto> posts = xmlParser.fromFile(POST_PATH, PostWrapper.class).getPosts();

        for (PostImportDto post : posts) {

            if(!validationUtils.isValid(post) ||
            pictureRepository.findFirstByPath(post.getPicture().getPath()).isEmpty()
            || userRepository.findFirstByUsername(post.getUser().getUsername()).isEmpty()){
                sb.append("Invalid Post")
                        .append(System.lineSeparator());
                continue;
            }

            Post postToSave = this.modelMapper.map(post, Post.class);

            Optional<Picture> path = pictureRepository.findFirstByPath(post.getPicture().getPath());

            Optional<User> firstByUsername = userRepository.findFirstByUsername(post.getUser().getUsername());

            postToSave.setPicture(path.get());
            postToSave.setUser(firstByUsername.get());

            postRepository.save(postToSave);

            sb.append(String.format("Successfully imported Post, made by %s",
                            post.getUser().getUsername()))
                    .append(System.lineSeparator());


        }


        return sb.toString().trim();
    }
}
