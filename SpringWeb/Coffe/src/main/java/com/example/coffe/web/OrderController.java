package com.example.coffe.web;

import com.example.coffe.model.binding.AddOrderBindingModel;
import com.example.coffe.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ModelAttribute
    public AddOrderBindingModel addOrderBindingModel(){
        return new AddOrderBindingModel();
    }

    @GetMapping("/add")
    public String add(){
        return "order-add";
    }

    @PostMapping("/add")
    public String confirmAddProduct(@Valid AddOrderBindingModel addOrderBindingModel,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes
                                    ){
        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("addOrderBindingModel",addOrderBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addOrderBindingModel", bindingResult);


           return "redirect:add";


        }


        orderService.addProduct(addOrderBindingModel);

        return "redirect:/";
    }

    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){

        orderService.readyOrder(id);

        return "redirect:/";
    }
}
