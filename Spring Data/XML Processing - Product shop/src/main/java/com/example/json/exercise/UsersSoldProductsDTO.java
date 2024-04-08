package com.example.json.exercise;


import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersSoldProductsDTO {

    @XmlAttribute(name="first-name")
    private String firstName;

    @XmlAttribute(name="last-name")
    private String lastName;

    @XmlElementWrapper(name="sold-products")
    private Set<ProductsSoldDTO> products;


    public UsersSoldProductsDTO(List<UsersSoldProductsDTO> soldProducts) {
        this.products = new HashSet<>();
    }
}
