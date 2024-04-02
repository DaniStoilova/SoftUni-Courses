package com.example.shoppinglist.web;

import com.example.shoppinglist.model.binding.AddBindingModel;
import com.example.shoppinglist.service.ProductService;
import com.example.shoppinglist.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {


    private final ProductService productService;

    private final CurrentUser currentUser;

    public ProductController(ProductService productService, CurrentUser currentUser) {
        this.productService = productService;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String add(){
        return "product-add";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid AddBindingModel addBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("addBindingModel",addBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addBindingModel",bindingResult);

            return "redirect:add";

        }


        productService.addProduct(addBindingModel);


        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyItem(@PathVariable Long id) {

        this.productService.buyItem(id);

        return "redirect:/";
    }

    @GetMapping("/buyAll")
    public String buyAllItems(){

        this.productService.buyAllItems();

        return "redirect:/";
    }

    @ModelAttribute
    public AddBindingModel addBindingModel(){
        return new AddBindingModel();
    }



}
