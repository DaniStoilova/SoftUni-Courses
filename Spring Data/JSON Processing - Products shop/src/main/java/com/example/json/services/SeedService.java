package com.example.json.services;

import java.io.IOException;
import java.io.Serializable;

public interface SeedService {
    void seedUsers() throws IOException;
    void seedCategories() throws IOException;
    void seedProducts() throws IOException;

    default void seedAll() throws IOException {
        seedUsers();
        seedCategories();
        seedProducts();


    }
}
