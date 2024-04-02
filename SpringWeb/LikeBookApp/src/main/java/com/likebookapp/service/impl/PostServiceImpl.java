package com.likebookapp.service.impl;

import com.likebookapp.init.CurrentUser;
import com.likebookapp.model.binding.AddPostBindingModel;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.MoodService;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final CurrentUser currentUser;

    private final MoodService moodService;

    private  final UserService userService;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, MoodService moodService, UserService userService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.moodService = moodService;
        this.userService = userService;
    }


    @Override
    public void add(AddPostBindingModel addPostBindingModel) {
        Post post = modelMapper.map(addPostBindingModel,Post.class);

        post.setMood(moodService.findByMoodName(addPostBindingModel.getMood()));
        post.setCreator(userService.findById(currentUser.getId()));
        post.setContent(post.getContent());

        postRepository.save(post);


    }

    @Override
    public void removePostById(Long id) {
        postRepository.deleteById(id);
    }


    @Override
    public Set<Post> getPostsFromCurrentUser(Long id) {
        return postRepository.findAllByCreatorId(id);
    }

    @Override
    public Set<Post> getOtherPost() {

        return this.postRepository.findAllByCreatorIdNot(currentUser.getId());
    }

    @Override
    public void likePost(Long id) {

        Optional<Post> postId = this.postRepository.findById(id);

        if (postId.isPresent()){
            User user = userRepository.findByUsername(currentUser.getUsername());
            Post post = postId.get();
            if (!post.getUserLikes().contains(user)) {
               // post.setUserLikes(user);
                this.postRepository.save(post);
            }
        }


    }

}
