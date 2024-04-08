package com.example.json.wrapper;

import com.example.json.entities.Category;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name="categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryImportWrapperModel {


    @XmlElement(name="category")
    List<CategoryImportModel> categories;
}


