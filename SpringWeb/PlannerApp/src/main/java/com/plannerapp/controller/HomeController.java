package com.plannerapp.controller;

import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import com.plannerapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;

    private  final TaskService taskService;

    private final UserService userService;

    public HomeController(CurrentUser currentUser, TaskService taskService, UserService userService) {
        this.currentUser = currentUser;

        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){

        if(currentUser.getId() == null){
            return "index";
        }


        model.addAttribute("username",currentUser.getUsername());
        model.addAttribute("assignedToMe", taskService.findAllAssignedToMe(currentUser.getId()));
        model.addAttribute("others",taskService.findAllAvailableTask());





        return "home";

    }



}
