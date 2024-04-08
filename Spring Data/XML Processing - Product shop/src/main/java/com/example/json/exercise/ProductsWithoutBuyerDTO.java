package com.example.json.exercise;

import com.example.json.entities.Product;
import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsWithoutBuyerDTO {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;

    @XmlAttribute(name="seller")
    @SerializedName(value="seller")
    private String seller;

    public ProductsWithoutBuyerDTO() {
    }

    public ProductsWithoutBuyerDTO(String name, BigDecimal price, String seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
    }

    public static ProductsWithoutBuyerDTO getProductFullName(Product product){

        String fullName = product.getSeller().getFirstName() + " " +
                product.getSeller().getLastName();
        return new ProductsWithoutBuyerDTO(product.getName(), product.getPrice(),fullName);
    }

}
