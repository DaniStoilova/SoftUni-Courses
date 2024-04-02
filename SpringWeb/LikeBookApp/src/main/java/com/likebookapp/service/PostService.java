package com.likebookapp.service;

import com.likebookapp.model.binding.AddPostBindingModel;
import com.likebookapp.model.entity.Post;

import java.util.Set;

public interface PostService {
    void add(AddPostBindingModel addPostBindingModel);

    void removePostById(Long id);

    Set<Post> getPostsFromCurrentUser(Long id);

    Set<Post> getOtherPost();


    void likePost(Long id);
}
