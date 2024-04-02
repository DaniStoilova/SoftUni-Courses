package com.resellerapp.controller;

import com.resellerapp.model.binding.AddOfferBindingModel;
import com.resellerapp.model.helper.CurrentUser;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class OfferController {

    private OfferService offerService;

    private CurrentUser currentUser;

    public OfferController(OfferService offerService, CurrentUser currentUser) {
        this.offerService = offerService;
        this.currentUser = currentUser;
    }


    @GetMapping("/add")
    public String add(){
     if (!currentUser.isLogged()) {
        return "redirect:/login";
    }
        return "offer-add";
    }

    @PostMapping("/add")
    public String confirm(@Valid AddOfferBindingModel addOfferBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("addOfferBindingModel", addOfferBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addOfferBindingModel", bindingResult);

            return "redirect:add";
        }

        offerService.addOffer(addOfferBindingModel);

        return "redirect:/home";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        offerService.remove(id);

        return "redirect:/home";
    }


    @GetMapping("/buy/{id}")
    public String buyOffer(@PathVariable("id") UUID id) {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        offerService.buy(id);
        return "redirect:/home";
    }

    @ModelAttribute
    public AddOfferBindingModel addOfferBindingModel(){
        return new AddOfferBindingModel();
    }
}
