package com.example.json.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ProductDtoWithCount4 {

    private Integer count;
    private List<ProductDto> products;

    public ProductDtoWithCount4() {
    }

    public ProductDtoWithCount4(int size, List<ProductDto> products) {
    }

    public ProductDtoWithCount4(List<ProductDto> products) {
        this.products = products;
        this.count = products.size();
    }

    public static ProductDtoWithCount4 productsSoldWithCountDto(List<ProductDto> products) {
        return new ProductDtoWithCount4(products.size(), products);
    }
}
