package com.example.coffe.service;

import com.example.coffe.model.binding.AddOrderBindingModel;
import com.example.coffe.model.binding.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addProduct(AddOrderBindingModel addOrderBindingModel);

    List<OrderViewModel> findAllOrderByPriceDesc();

    void readyOrder(Long id);

}
