package com.example.json.services;

import com.example.json.models.CategorySummaryDTO;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategorySummaryDTO> getCategorySummary() throws IOException;
}
