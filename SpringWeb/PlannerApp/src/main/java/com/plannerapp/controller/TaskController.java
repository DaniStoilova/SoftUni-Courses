package com.plannerapp.controller;

import com.plannerapp.model.binding.AddTaskBindingModel;
import com.plannerapp.service.TaskService;
import com.plannerapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TaskController {

    private final TaskService taskService;

    private final CurrentUser currentUser;

    public TaskController(TaskService taskService, CurrentUser currentUser) {
        this.taskService = taskService;
        this.currentUser = currentUser;
    }


    @GetMapping("/add")
    public String add() {
        return "task-add";
    }

    @PostMapping("/add")
    public String confirmTask(@Valid AddTaskBindingModel addTaskBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addTaskBindingModel", addTaskBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addTaskBindingModel", bindingResult);

            return "redirect:add";
        }


        taskService.addTask(addTaskBindingModel);

        return "redirect:/";
    }
    @ModelAttribute
    public AddTaskBindingModel addTaskBindingModel(){
        return new AddTaskBindingModel();
    }

    @GetMapping("/return/{id}")
    public String taskOther(@PathVariable Long id){

        taskService.taskToReturn(id,null);

        return "redirect:/";
    }
    @GetMapping("/assign/{id}")
    public String assign(@PathVariable("id") Long id) {

        taskService.taskToReturn(id, currentUser.getUsername());

        return "redirect:/";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {

        taskService.remove(id);

        return "redirect:/";
    }






}
