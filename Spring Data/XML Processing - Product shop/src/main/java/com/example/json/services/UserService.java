package com.example.json.services;


import com.example.json.exercise.Users4WithProducts4;
import com.example.json.exercise.UsersSoldProductsDTO;
import com.example.json.exercise.WrapperSold;
import jakarta.xml.bind.JAXBException;

import java.util.List;

public interface UserService {

  List<UsersSoldProductsDTO> findAllByProductsSaleBuyerIsNotNullOrderByProductsSaleBuyerLastNameAscProductsSaleBuyerFirstName() throws JAXBException;


  Users4WithProducts4 findUsersAndProducts() throws JAXBException;
}
