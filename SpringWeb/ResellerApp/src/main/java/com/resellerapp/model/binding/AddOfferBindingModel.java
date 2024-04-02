package com.resellerapp.model.binding;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionEnum;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class AddOfferBindingModel {

    @NotNull
    @Size(min=2,max=50,message="Description length must be between 2 and 50 characters!")
    private String description;

    @NotNull(message = "Price must be a positive number!")
    @Positive
    private BigDecimal price;

    @NotNull(message = "You must select a condition!")
    private ConditionEnum condition;

    public AddOfferBindingModel() {
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

    public ConditionEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionEnum condition) {
        this.condition = condition;
    }
}
