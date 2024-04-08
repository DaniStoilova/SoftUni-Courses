package com.example.json.services;

import com.example.json.entities.User;
import com.example.json.models.Users4WithProducts4;

import com.example.json.models.Users4WithProductsDTO;
import com.example.json.models.UsersSoldProductsDTO;
import com.example.json.repositories.UserRepository;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import static com.example.json.constants.Path.FOUR_PATH;
import static com.example.json.constants.Path.SECOND_PATH;
import static com.example.json.constants.Utils.result;
import static com.example.json.constants.Utils.resultToJSON;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Gson gson;

   ModelMapper modelMapper = new ModelMapper();

    public UserServiceImpl(UserRepository userRepository, Gson gson) {
        this.userRepository = userRepository;

        this.gson = gson;
    }


    @Override
    public List<UsersSoldProductsDTO> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName() throws IOException {
        List<UsersSoldProductsDTO> users = userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName()
                .stream()
                .map(u -> modelMapper.map(u, UsersSoldProductsDTO.class))
                .toList();

        resultToJSON(users, SECOND_PATH);

        return users;
    }

    @Override
    public Users4WithProducts4 findUsersAndProducts() throws IOException {

        List<User> users = userRepository.usersAndProducts();


        List<Users4WithProductsDTO> usersSoldProductsList = users.stream()
                .map(u -> {
                    Users4WithProductsDTO user = modelMapper.map(u, Users4WithProductsDTO.class);

                    user.getSoldProducts().setCount(u.getSoldProducts().size());

                    return user;
                })
                .collect(Collectors.toList());

        Users4WithProducts4 products = new Users4WithProducts4(usersSoldProductsList);



        gson.toJson(products);

        result(products,FOUR_PATH);



        return products;

    }


}

