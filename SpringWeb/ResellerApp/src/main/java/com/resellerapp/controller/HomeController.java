package com.resellerapp.controller;

import com.resellerapp.model.entity.User;
import com.resellerapp.model.helper.CurrentUser;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private CurrentUser currentUser;

    private OfferService offerService;

    private UserRepository userRepository;

    public HomeController(CurrentUser currentUser, OfferService offerService, UserRepository userRepository) {
        this.currentUser = currentUser;
        this.offerService = offerService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index() {
        if (!currentUser.isLogged()) {
            return "index";
        }
        return "home";
    }


    @GetMapping("/home")
    public String home(Model model) {
        if (!currentUser.isLogged()) {
            return "index";
        }

        String username = currentUser.getUsername();

        User user = userRepository.findByUsername(username);

        model.addAttribute("username",username);

        model.addAttribute("myOffer",offerService.getMyOffer(user));

        model.addAttribute("otherOffer",offerService.getOtherOffer(user));

        model.addAttribute("boughtOffer",offerService.getBought(user));

        return "home";

    }


}
