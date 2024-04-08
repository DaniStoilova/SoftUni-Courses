package com.example.json.constants;

import com.example.json.entities.Product;
import com.example.json.entities.User;
import com.example.json.models.ProductsWithoutBuyerDTO;
import com.example.json.models.Users4WithProducts4;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public enum Utils {
    ;

   public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void resultToJSON(List<T> allProducts, Path path) throws IOException {

        FileWriter fileWriter = new FileWriter(path.toFile());

        gson.toJson(allProducts,fileWriter);

        fileWriter.flush();
        fileWriter.close();


    }
    public static <T> void result(Users4WithProducts4 user, Path path) throws IOException {

        FileWriter fileWriter = new FileWriter(path.toFile());

        gson.toJson(user,fileWriter);

        fileWriter.flush();
        fileWriter.close();


    }
}
