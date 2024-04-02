package com.example.coffe.service.Impl;

import com.example.coffe.model.entity.Category;
import com.example.coffe.model.enums.CategoryEnum;
import com.example.coffe.repository.CategoryRepository;
import com.example.coffe.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByCategoryName(CategoryEnum category) {
        return categoryRepository.findByName(category).orElse(null);
    }
}
