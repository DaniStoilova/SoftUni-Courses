package com.example.json.exercise;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSoldDTO {

    @XmlElement
    private String name;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name="buyer-first-name")
    private String buyerFirstName;

    @XmlElement(name="buyer-last-name")
    private String buyerLastName;

    public ProductsSoldDTO() {
    }

//    public ProductsSoldDTO(String name, BigDecimal price, String buyerFirstName, String buyerLastName) {
//        this.name = name;
//        this.price = price;
//        this.buyerFirstName = buyerFirstName;
//        this.buyerLastName = buyerLastName;
//    }
}
