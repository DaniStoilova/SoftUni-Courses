package com.resellerapp.model.dto;

import java.math.BigDecimal;

public class BoughtDTO {

    private String description;

    private BigDecimal price;

    public BoughtDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
