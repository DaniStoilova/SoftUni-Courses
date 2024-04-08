package com.example.json;
import com.example.json.services.CategoryService;
import com.example.json.services.ProductService;
import com.example.json.services.SeedService;
import com.example.json.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Runner implements CommandLineRunner{

    private final SeedService seedService;
    private final ProductService productService;

    private final CategoryService categoryService;
    private final UserService userService;

    public Runner(SeedService seedService, ProductService productService, CategoryService categoryService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.categoryService = categoryService;

        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

//        seedService.seedUsers();
//        seedService.seedCategories();
//        seedService.seedProducts();
//
        productService.getProductsSpecifiedInPriceRange(BigDecimal.valueOf(500),BigDecimal.valueOf(1000));
        userService.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName();
        categoryService.getCategorySummary();
        userService.findUsersAndProducts();




    }
}
