package com.likebookapp.controller;

import com.likebookapp.init.CurrentUser;
import com.likebookapp.model.binding.AddPostBindingModel;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {


    private final PostService postService;

    private final CurrentUser currentUser;

    public PostController(PostService postService, CurrentUser currentUser) {
        this.postService = postService;
        this.currentUser = currentUser;
    }


    @GetMapping("/add")
    public String add(){
        return "post-add";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid AddPostBindingModel  addPostBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("addPostBindingModel",addPostBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addPostBindingModel",bindingResult);

            return "redirect:add";
        }

        postService.add(addPostBindingModel);


        return "redirect:/";

    }

    @GetMapping("/like-post/{id}")
    public String likePost(@PathVariable Long id){

        postService.likePost(id);

        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String removePost(@PathVariable Long id){

        postService.removePostById(id);

        return "redirect:/";
    }


    @ModelAttribute
    public AddPostBindingModel addPostBindingModel(){
        return new AddPostBindingModel();
    }
}
