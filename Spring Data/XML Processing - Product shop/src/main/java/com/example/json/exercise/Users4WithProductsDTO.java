package com.example.json.exercise;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Users4WithProductsDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute(name = "age")
    private Integer age;
    @XmlElement(name = "sold-products")
    private SoldProductsCountDto soldProducts;

    public Users4WithProductsDTO() {
    }

    public Users4WithProductsDTO(String firstName, String lastName, Integer age, List<SoldProductsCountDto> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.soldProducts = new SoldProductsCountDto();
    }
}
