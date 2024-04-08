package com.example.json.services;

import com.example.json.exercise.ProductsWithoutBuyerDTO;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductsWithoutBuyerDTO> getProductsSpecifiedInPriceRange(BigDecimal low, BigDecimal high) throws IOException, JAXBException;
}
