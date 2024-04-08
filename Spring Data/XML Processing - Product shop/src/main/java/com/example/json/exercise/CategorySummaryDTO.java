package com.example.json.exercise;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySummaryDTO {


    @XmlAttribute(name="name")
    private String category;

    @XmlElement(name="product-count")
    private Long productsCount;

    @XmlElement(name="average-price")
    private Double averagePrice;

    @XmlElement(name="total-revenue")
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
