package com.example.andres.service;

import com.example.andres.model.binding.AddItemBindingModel;
import com.example.andres.model.binding.ItemDTO;

import java.util.List;

public interface ItemService {
    void confirm(AddItemBindingModel addItemBindingModel);

    List<ItemDTO> getAll();

    ItemDTO findById(Long id);

    void delete(Long id);
}
