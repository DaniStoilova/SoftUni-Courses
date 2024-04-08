package com.example.json.services;

import com.example.json.models.Users4WithProducts4;
import com.example.json.models.UsersSoldProductsDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {

  List<UsersSoldProductsDTO> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName() throws IOException;


  Users4WithProducts4 findUsersAndProducts() throws IOException;
}
