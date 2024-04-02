package com.likebookapp.controller;

import com.likebookapp.init.CurrentUser;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {

    private CurrentUser currentUser;

    private UserService userService;

    private PostService postService;

    public HomeController(CurrentUser currentUser, UserService userService, PostService postService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.postService = postService;
    }


    @GetMapping
    public String index(Model model){

        if (currentUser.getId() == null){
            return "index";
        }


        User user = userService.findUserById(currentUser.getId());
        model.addAttribute("info", user);

        Set<Post> postsFromCurrentUser = postService.getPostsFromCurrentUser(currentUser.getId());

        model.addAttribute("userPosts", postsFromCurrentUser);

        Set<Post> postsFromOtherUsers = postService.getOtherPost();

        model.addAttribute("otherUserPosts", postsFromOtherUsers);



        return "home";


    }
}
