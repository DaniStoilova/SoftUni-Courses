package com.example.json.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class CategorySummaryDTO {


    private String category;


    private Long productsCount;


    private Double averagePrice;


    private BigDecimal totalRevenue;

    public CategorySummaryDTO() {
    }

    public CategorySummaryDTO(String category, Long productsCount, Double averagePrice, BigDecimal totalRevenue) {
        this.category = category;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }
}
