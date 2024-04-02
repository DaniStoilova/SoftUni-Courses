package com.resellerapp.model.dto;

import com.resellerapp.model.entity.Condition;


import java.math.BigDecimal;
import java.util.UUID;

public class OtherDTO {

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;

    private String username;

    private String description;


    private BigDecimal price;

    private Condition condition;

    public OtherDTO() {

    }

    public String getUsername() {
        return username;
    }

    public OtherDTO setUsername(String username) {
        this.username = username;
       return this;
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

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
