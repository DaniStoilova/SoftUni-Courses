package com.example.bookdemo.service;

import com.example.bookdemo.Entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();

}
