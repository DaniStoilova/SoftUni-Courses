package com.example.shoppinglist.service;

import com.example.shoppinglist.model.binding.AddBindingModel;
import com.example.shoppinglist.model.binding.ProductDTO;
import com.example.shoppinglist.model.enums.CategoryEnum;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addProduct(AddBindingModel addBindingModel);

    List<ProductDTO> findProductsByCategoryName(CategoryEnum categoryEnum);

    BigDecimal getProductTotalSum();

    void buyItem(Long id);

    void buyAllItems();
}
