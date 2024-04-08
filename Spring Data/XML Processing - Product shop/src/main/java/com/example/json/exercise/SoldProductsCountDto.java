package com.example.json.exercise;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsCountDto {
        @XmlAttribute()
        private Integer count;

        @XmlElement(name = "product" )
//        @SerializedName("products")
        private List<ProductNameAndPriceDto> soldProducts;

        public SoldProductsCountDto() {

        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public List<ProductNameAndPriceDto> getSoldProducts() {
            return soldProducts;
        }

        public void setSoldProducts(List<ProductNameAndPriceDto> soldProducts) {
            this.soldProducts = soldProducts;
        }
    }

