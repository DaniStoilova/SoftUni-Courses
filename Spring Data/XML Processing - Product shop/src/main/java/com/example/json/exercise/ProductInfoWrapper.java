package com.example.json.exercise;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInfoWrapper {

    @XmlElement(name="product")
    List<ProductsWithoutBuyerDTO> products;

    public ProductInfoWrapper(List<ProductsWithoutBuyerDTO> products) {
        this.products = products;
    }

    public ProductInfoWrapper() {
    }
}
