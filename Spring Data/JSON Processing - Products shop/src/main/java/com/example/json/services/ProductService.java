package com.example.json.services;

import com.example.json.models.ProductsWithoutBuyerDTO;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductsWithoutBuyerDTO> getProductsSpecifiedInPriceRange(BigDecimal low, BigDecimal high) throws IOException;
}
