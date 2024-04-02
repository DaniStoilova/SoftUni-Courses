package com.example.batteleship.service;

import com.example.batteleship.model.binding.AddBindingModel;
import com.example.batteleship.model.entity.Ship;

import java.util.List;

public interface ShipService {
    void confirmAdd(AddBindingModel addBindingModel);

    List<Ship> findAllAttacker(Long id);

    List<Ship> findAllDefender();




}
