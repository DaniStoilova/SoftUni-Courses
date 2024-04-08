package com.example.json.services;

import com.example.json.entities.Category;
import com.example.json.entities.Product;
import com.example.json.entities.User;
import com.example.json.models.CategoryDto;
import com.example.json.models.ProductDto;
import com.example.json.models.UserDto;
import com.example.json.repositories.CategoryRepository;
import com.example.json.repositories.ProductRepository;
import com.example.json.repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
;

@Service
public class SeedServiceImpl implements SeedService {

    private final Path CATEGORIES_PATH = Path.of("src", "main", "resources", "content", "categories.json");
    private final Path USER_PATH = Path.of("src", "main", "resources", "content", "users.json");
    private final Path PRODUCT_PATH = Path.of("src", "main", "resources", "content", "products.json");


    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository,
                           CategoryRepository categoryRepository,
                           ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;

        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void seedUsers() throws  FileNotFoundException {
        if (userRepository.count() > 0) {
            return;
        }
        FileReader fileReader = new FileReader(USER_PATH.toFile());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ModelMapper modelMapper = new ModelMapper();

        List<User> users = Arrays.stream(gson.fromJson(fileReader, UserDto[].class))
                .map(userModel -> modelMapper.map(userModel, User.class))
                .toList();

        this.userRepository.saveAll(users);

    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        if (categoryRepository.count() > 0) {
            return;
        }
        FileReader fileReader = new FileReader(CATEGORIES_PATH.toFile());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ModelMapper modelMapper = new ModelMapper();

        List<Category> categories = Arrays.stream(gson.fromJson(fileReader, CategoryDto[].class))
                .map(categoryModel -> modelMapper.map(categoryModel, Category.class))
                .toList();

        this.categoryRepository.saveAll(categories);


    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        FileReader fileReader = new FileReader(PRODUCT_PATH.toFile());
        ProductDto[] productImportDTOS = this.gson.fromJson(fileReader, ProductDto[].class);

        List<Product> products = Arrays.stream(productImportDTOS)
                .map(importDTO -> this.modelMapper.map(importDTO, Product.class))
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .map(this::sendRandomCategories)
                .collect(Collectors.toList());

        this.productRepository.saveAll(products);
    }

    private Product sendRandomCategories(Product product) {
        Random random = new Random();
        long categoriesDbCount = this.categoryRepository.count();

        int count = random.nextInt((int) categoriesDbCount);

        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int randomId = random.nextInt((int) categoriesDbCount) + 1;

            Optional<Category> randomCategory = this.categoryRepository.findById((long) randomId);

            categories.add(randomCategory.get());
        }

        product.setCategories(categories);
        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(500)) > 0) {
            return product;
        }

        Optional<User> buyer = getRandomUser();

        product.setBuyer(buyer.get());

        return product;
    }

    private Product setRandomSeller(Product product) {
        Optional<User> seller = getRandomUser();

        product.setSeller(seller.get());

        return product;
    }

    private Optional<User> getRandomUser() {
        long usersCount = this.userRepository.count();

        int randomUserId = new Random().nextInt((int) usersCount) + 1;

        Optional<User> seller = this.userRepository.findById((long) randomUserId);
        return seller;
    }
}

