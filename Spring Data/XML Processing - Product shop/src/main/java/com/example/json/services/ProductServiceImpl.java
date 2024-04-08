package com.example.json.services;

import com.example.json.exercise.ProductInfoWrapper;
import com.example.json.exercise.ProductsWithoutBuyerDTO;
import com.example.json.repositories.ProductRepository;
import jakarta.xml.bind.JAXBException;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.example.json.constants.Path.FIRST_PATH;
import static com.example.json.constants.Utils.resultXmlFile;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductsWithoutBuyerDTO> getProductsSpecifiedInPriceRange(BigDecimal low, BigDecimal high) throws JAXBException {
        List<ProductsWithoutBuyerDTO> allProducts = productRepository.
                findAllByPriceBetweenAndBuyerIsNullOrderByPrice(low, high)
                .stream()
                .map(ProductsWithoutBuyerDTO::getProductFullName)
                .toList();

        ProductInfoWrapper productInfoWrapper = new ProductInfoWrapper(allProducts);



        resultXmlFile(productInfoWrapper, FIRST_PATH);


        return allProducts;
    }
}
