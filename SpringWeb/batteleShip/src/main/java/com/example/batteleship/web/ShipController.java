package com.example.batteleship.web;

import com.example.batteleship.model.binding.AddBindingModel;
import com.example.batteleship.service.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/add")
    public String add(){
        return "ship-add";
    }

    @PostMapping("/add")
    public String addShip(@Valid AddBindingModel addBindingModel,
                          BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){

            redirectAttributes
                    .addFlashAttribute("addBindingModel",addBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addBindingModel",bindingResult);

            return "redirect:add";
        }


      shipService.confirmAdd(addBindingModel);


        return "redirect:/";
    }



    @ModelAttribute
    public AddBindingModel addBindingModel(){
        return new AddBindingModel();
    }

}
