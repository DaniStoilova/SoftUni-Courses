package com.example.batteleship.web;

import com.example.batteleship.model.entity.Ship;
import com.example.batteleship.repository.ShipRepository;
import com.example.batteleship.service.ShipService;
import com.example.batteleship.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private CurrentUser currentUser;

    private ShipService shipService;

    private ShipRepository shipRepository;

    public HomeController(CurrentUser currentUser, ShipService shipService, ShipRepository shipRepository) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.shipRepository = shipRepository;
    }


    @GetMapping("/")
    public String index(Model model){

        if (currentUser.getId() == null){
            return "index";
        }

        List<Ship> allAttacker = shipService.findAllAttacker(currentUser.getId());
        List<Ship> allDefender = shipService.findAllDefender();


        model.addAttribute("current",allAttacker);
        model.addAttribute("other",allDefender);
       model.addAttribute("allShips",shipRepository.findAll());



        return "home";
    }
//    @PostMapping("/battle")
//    public String getHome()  {
//
//        this.shipService.fight();
//
//        return "redirect:home";
//    }



}
