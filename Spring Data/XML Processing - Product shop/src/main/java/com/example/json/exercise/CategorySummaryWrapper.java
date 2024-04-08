package com.example.json.exercise;

import com.example.json.exercise.CategorySummaryDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name="categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySummaryWrapper {

    @XmlElement(name="category")
    List<CategorySummaryDTO> categories;

    public CategorySummaryWrapper() {
    }

    public CategorySummaryWrapper(List<CategorySummaryDTO> categories) {
        this.categories = categories;
    }
}
