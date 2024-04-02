package com.example.shoppinglist.service.Impl;

import com.example.shoppinglist.model.binding.AddBindingModel;
import com.example.shoppinglist.model.binding.ProductDTO;
import com.example.shoppinglist.model.entity.Product;
import com.example.shoppinglist.model.entity.User;
import com.example.shoppinglist.model.enums.CategoryEnum;
import com.example.shoppinglist.repository.CategoryRepository;
import com.example.shoppinglist.repository.ProductRepository;
import com.example.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addProduct(AddBindingModel addBindingModel) {
        Product product = modelMapper.map(addBindingModel,Product.class);

        product.setCategory(categoryRepository.findByName(addBindingModel.getCategory()));

        productRepository.save(product);

    }

    @Override
    public List<ProductDTO> findProductsByCategoryName(CategoryEnum categoryEnum) {
        return productRepository
                .findAllByCategory_Name(categoryEnum)
                .stream()
                .map(p-> modelMapper.map(p,ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getProductTotalSum() {
        return productRepository.findAllByPrice();
    }

    @Override
    public void buyItem(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAllItems() {
        productRepository.deleteAll();
    }
}
