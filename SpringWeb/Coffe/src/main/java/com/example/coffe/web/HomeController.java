package com.example.coffe.web;

import com.example.coffe.init.CurrentUser;
import com.example.coffe.model.binding.OrderViewModel;
import com.example.coffe.service.OrderService;
import com.example.coffe.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;

    private final OrderService orderService;

    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;

        this.userService = userService;
    }


    @GetMapping
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

            List<OrderViewModel> orders = orderService.findAllOrderByPriceDesc();

            model.addAttribute("orders", orders);
            model.addAttribute("totalTime",
                    orders.stream()
                            .map(orderView ->
                                    orderView.getCategory()
                                            .getNeededTime())
                            .reduce((a, b) -> Integer.sum(a, b)).orElse(null));

            model.addAttribute("users", userService.findAllUserAndCountOrderOrderByCountOrderDesc());

            return "home";
    }




}



