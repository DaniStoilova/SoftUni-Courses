package com.example.json.exercise;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users4WithProducts4 {

    @XmlAttribute(name = "count")
    private Integer usersCount;
    @XmlElement(name = "user")
    private List<Users4WithProductsDTO> users;

    public Users4WithProducts4() {
    }

    public Users4WithProducts4(List<Users4WithProductsDTO> users) {
        this.users = users;
        this.usersCount = users.size();
    }
}
