package com.example.shoppinglist.web;

import com.example.shoppinglist.model.enums.CategoryEnum;
import com.example.shoppinglist.service.ProductService;
import com.example.shoppinglist.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;

    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(Model model ){

        if (currentUser.getId() == null){
            return "index";
        }

        model.addAttribute("foods", productService.findProductsByCategoryName(CategoryEnum.Food));
        model.addAttribute("drinks", productService.findProductsByCategoryName(CategoryEnum.Drink));
        model.addAttribute("householders", productService.findProductsByCategoryName(CategoryEnum.Household));
        model.addAttribute("others", productService.findProductsByCategoryName(CategoryEnum.Other));
        model.addAttribute("total",productService.getProductTotalSum());



        return "home";
    }


}
