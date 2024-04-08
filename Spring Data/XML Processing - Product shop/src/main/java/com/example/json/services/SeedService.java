package com.example.json.services;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.io.Serializable;

public interface SeedService {
    void seedUsers() throws IOException, JAXBException;
    void seedCategories() throws IOException, JAXBException;
    void seedProducts() throws IOException, JAXBException;

//    default void seedAll() throws IOException {
//        seedUsers();
//        seedCategories();
//        seedProducts();
//
//
//    }
}
