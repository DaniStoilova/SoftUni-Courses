package com.example.andres.web;

import com.example.andres.model.binding.AddItemBindingModel;
import com.example.andres.model.helper.CurrentUser;
import com.example.andres.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ItemController {

    private ItemService itemService;

    private CurrentUser currentUser;

    public ItemController(ItemService itemService, CurrentUser currentUser) {
        this.itemService = itemService;
        this.currentUser = currentUser;
    }


    @GetMapping("/add")
    public String add(){
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }
        return "add-product";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid AddItemBindingModel addItemBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("addItemBindingModel", addItemBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addItemBindingModel", bindingResult);


            return "redirect:add";
        }


        itemService.confirm(addItemBindingModel);


        return "redirect:/home";
    }


    @GetMapping("/detail/{id}")
    public String  details(@PathVariable("id") Long id, Model model){
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        model.addAttribute("detailItem", itemService.findById(id));

        return "details-product";
    }

    @GetMapping("delete/{id}")
    public String del(@PathVariable("id") Long id){
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        itemService.delete(id);

        return "redirect:/";
    }

    @ModelAttribute
    public AddItemBindingModel addItemBindingModel(){
        return new AddItemBindingModel();
    }
}
