package com.example.coffe.service;

import com.example.coffe.model.entity.Category;
import com.example.coffe.model.enums.CategoryEnum;

public interface CategoryService {

    Category findByCategoryName(CategoryEnum category);
}
