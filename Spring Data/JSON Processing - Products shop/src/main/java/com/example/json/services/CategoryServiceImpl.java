package com.example.json.services;

import com.example.json.models.CategorySummaryDTO;
import com.example.json.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.example.json.constants.Path.FIRST_PATH;
import static com.example.json.constants.Path.THIRD_PATH;
import static com.example.json.constants.Utils.resultToJSON;

@Service
public class CategoryServiceImpl implements CategoryService{


    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategorySummaryDTO> getCategorySummary() throws IOException {
        List<CategorySummaryDTO> categorySummary = categoryRepository
                .getCategorySummary();

        resultToJSON(categorySummary, THIRD_PATH);




        return categorySummary;

    }
}
