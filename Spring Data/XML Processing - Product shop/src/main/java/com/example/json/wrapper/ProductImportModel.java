package com.example.json.wrapper;

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
public class ProductImportModel {

    @XmlElement(name="name")
    private String name;
    @XmlElement(name="price")
    private BigDecimal price;



}
