package com.example.json.models;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UsersSoldProductsDTO {

    private String firstName;

    private String lastName;

    private Set<ProductsSoldDTO> soldProducts;

}
