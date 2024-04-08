package com.example.json.wrapper;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersImportModel {

    @XmlAttribute(name="first-name")
    private String firstName;

    @XmlAttribute(name="last-name")
    private String lastName;

    @XmlAttribute(name="age")
    private Integer age;




}
