package com.example.json.services;

import com.example.json.exercise.CategorySummaryDTO;
import com.example.json.exercise.CategorySummaryWrapper;
import com.example.json.repositories.CategoryRepository;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.json.constants.Path.THIRD_PATH;
import static com.example.json.constants.Utils.resultXmlFile;


@Service
public class CategoryServiceImpl implements CategoryService{


    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategorySummaryDTO> getCategorySummary() throws JAXBException,IllegalArgumentException {
        List<CategorySummaryDTO> categorySummary = categoryRepository.getCategorySummary();


        CategorySummaryWrapper summaryDTO = new CategorySummaryWrapper(categorySummary);

        resultXmlFile(summaryDTO, THIRD_PATH);

        return categorySummary;

    }
}
