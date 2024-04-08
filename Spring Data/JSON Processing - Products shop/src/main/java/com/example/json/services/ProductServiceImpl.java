package com.example.json.services;
import com.example.json.entities.Product;
import com.example.json.models.ProductsWithoutBuyerDTO;
import com.example.json.repositories.ProductRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;

import static com.example.json.constants.Path.FIRST_PATH;
import static com.example.json.constants.Utils.resultToJSON;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private Gson gson;


    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
        this.gson = new Gson();
    }

    @Override
    public List<ProductsWithoutBuyerDTO> getProductsSpecifiedInPriceRange(BigDecimal low, BigDecimal high) throws IOException {
        List<ProductsWithoutBuyerDTO> allProducts = productRepository.
                findAllByPriceBetweenAndBuyerIsNullOrderByPrice(low, high)
                .stream()
                .map(ProductsWithoutBuyerDTO::getProductFullName)
                .toList();

        resultToJSON(allProducts, FIRST_PATH);


        return allProducts;
    }
}


