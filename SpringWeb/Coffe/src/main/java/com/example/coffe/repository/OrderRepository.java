package com.example.coffe.repository;
import com.example.coffe.model.binding.OrderViewModel;
import com.example.coffe.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByOrderByPriceDesc();

}
