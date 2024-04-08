package com.example.json.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Users4WithProductsDTO {

    private String firstName;
    private String lastName;

    private Integer age;

    private ProductDtoWithCount4 soldProducts;

    public Users4WithProductsDTO() {
    }

    public Users4WithProductsDTO(String firstName, String lastName, Integer age, List<ProductDtoWithCount4> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.soldProducts = new ProductDtoWithCount4();
    }
}
