package com.example.json.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Users4WithProducts4 {
    private Integer usersCount;

    private List<Users4WithProductsDTO> users;

    public Users4WithProducts4(List<Users4WithProductsDTO> users) {
        this.users = users;
        this.usersCount = users.size();
    }
}
