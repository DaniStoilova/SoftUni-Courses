package com.example.json.services;

import com.example.json.entities.User;
import com.example.json.exercise.Users4WithProducts4;
import com.example.json.exercise.Users4WithProductsDTO;
import com.example.json.exercise.UsersSoldProductsDTO;
import com.example.json.exercise.WrapperSold;
import com.example.json.repositories.UserRepository;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.json.constants.Path.*;
import static com.example.json.constants.Utils.resultXmlFile;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

   ModelMapper modelMapper = new ModelMapper();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public List<UsersSoldProductsDTO> findAllByProductsSaleBuyerIsNotNullOrderByProductsSaleBuyerLastNameAscProductsSaleBuyerFirstName() throws JAXBException {
        List<UsersSoldProductsDTO> users = userRepository
                .findAllByProductsSaleBuyerIsNotNullOrderByProductsSaleBuyerLastNameAscProductsSaleBuyerFirstName()
                .stream()
                .map(u -> modelMapper.map(u, UsersSoldProductsDTO.class))
                .toList();

        WrapperSold usersSoldProductsDTO = new WrapperSold(users);

        resultXmlFile(usersSoldProductsDTO, SECOND_PATH);

        return users;
    }

    @Override
    public Users4WithProducts4 findUsersAndProducts() throws JAXBException {

        List<User> users = userRepository.usersAndProducts();


        List<Users4WithProductsDTO> usersSoldProductsList = users.stream()
                .map(u -> {
                    Users4WithProductsDTO user = modelMapper.map(u, Users4WithProductsDTO.class);

                    user.getSoldProducts().setCount(u.getSoldProducts().size());

                    return user;
                })
                .collect(Collectors.toList());

        Users4WithProducts4 products = new Users4WithProducts4(usersSoldProductsList);



        resultXmlFile(products, FOUR_PATH);


        return products;


    }

}

