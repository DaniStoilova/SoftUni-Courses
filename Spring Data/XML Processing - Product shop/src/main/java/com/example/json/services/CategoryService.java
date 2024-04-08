package com.example.json.services;


import com.example.json.exercise.CategorySummaryDTO;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.List;


public interface CategoryService {
    List<CategorySummaryDTO> getCategorySummary() throws IOException, JAXBException;
}
