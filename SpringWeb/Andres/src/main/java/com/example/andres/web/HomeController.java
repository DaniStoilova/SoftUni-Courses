package com.example.andres.web;

import com.example.andres.model.helper.CurrentUser;
import com.example.andres.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private CurrentUser currentUser;

    private ItemService itemService;

    public HomeController(CurrentUser currentUser, ItemService itemService) {
        this.currentUser = currentUser;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(){
        if (currentUser.isLogged()){
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){
        if (!currentUser.isLogged()){
            return "index";
        }

       model.addAttribute("allItems", itemService.getAll());


        return "home";
    }
}
