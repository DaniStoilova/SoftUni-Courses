package com.example.json.wrapper;

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
public class ProductImportWrapperModel {

    @XmlElement(name="product")
    List<ProductImportModel> products;
}
