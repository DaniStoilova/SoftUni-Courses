package com.example.json;
import com.example.json.services.CategoryService;
import com.example.json.services.ProductService;
import com.example.json.services.SeedService;
import com.example.json.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner{

    private final SeedService seedService;
    private final ProductService productService;

    private final UserService userService;

    private final CategoryService categoryService;

    public Runner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

//        seedService.seedUsers();
//        seedService.seedCategories();
//        seedService.seedProducts();

       // productService.getProductsSpecifiedInPriceRange(BigDecimal.valueOf(500),BigDecimal.valueOf(1000));
        //userService.findAllByProductsSaleBuyerIsNotNullOrderByProductsSaleBuyerLastNameAscProductsSaleBuyerFirstName();
        //categoryService.getCategorySummary();
        userService.findUsersAndProducts();

    }
}
