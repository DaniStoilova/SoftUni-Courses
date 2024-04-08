package com.example.json.models;

import com.example.json.entities.Product;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class ProductsWithoutBuyerDTO {

    private String name;
    private BigDecimal price;

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
