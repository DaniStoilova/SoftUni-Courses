package com.example.coffe.service.Impl;

import com.example.coffe.init.CurrentUser;
import com.example.coffe.model.binding.AddOrderBindingModel;
import com.example.coffe.model.binding.OrderViewModel;
import com.example.coffe.model.entity.Order;
import com.example.coffe.repository.OrderRepository;
import com.example.coffe.service.CategoryService;
import com.example.coffe.service.OrderService;
import com.example.coffe.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ModelMapper modelMapper;

    private final UserService userService;

    private final CurrentUser currentUser;

    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(AddOrderBindingModel addOrderBindingModel) {
        Order order = modelMapper.map(addOrderBindingModel,Order.class);

        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryName(addOrderBindingModel.getCategory()));

        orderRepository.save(order);

    }

    @Override
    public List<OrderViewModel> findAllOrderByPriceDesc() {

        return orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(order->modelMapper.map(order,OrderViewModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
