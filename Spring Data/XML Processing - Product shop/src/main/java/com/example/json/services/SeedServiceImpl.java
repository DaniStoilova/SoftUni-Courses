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
import com.example.json.wrapper.CategoryImportWrapperModel;
import com.example.json.wrapper.ProductImportWrapperModel;
import com.example.json.wrapper.UserImportWrapperModel;
import com.example.json.wrapper.UsersImportModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
;

@Service
public class SeedServiceImpl implements SeedService {

    private final Path CATEGORIES_PATH = Path.of("src", "main", "resources", "content", "categories.xml");
    private final Path USER_PATH = Path.of("src", "main", "resources", "content", "users.xml");
    private final Path PRODUCT_PATH = Path.of("src", "main", "resources", "content", "products.xml");


    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;


    @Autowired
    public SeedServiceImpl(UserRepository userRepository,
                           CategoryRepository categoryRepository,
                           ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;

        this.modelMapper = new ModelMapper();

    }

    @Override
    public void seedUsers() throws IOException, JAXBException {
        if (userRepository.count() > 0) {
            return;
        }
        FileReader fileReader = new FileReader(USER_PATH.toFile());

        JAXBContext jaxbContext = JAXBContext.newInstance(UserImportWrapperModel.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        UserImportWrapperModel userWrapperModel = (UserImportWrapperModel) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        List<User> users =
                userWrapperModel.getUsers()
                .stream()
                .map(u -> modelMapper.map(u, User.class))
                .toList();


        this.userRepository.saveAll(users);

    }

    @Override
    public void seedCategories() throws IOException, JAXBException {
        if (categoryRepository.count() > 0) {
            return;
        }
        final FileReader fileReader = new FileReader(CATEGORIES_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(CategoryImportWrapperModel.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        CategoryImportWrapperModel wrapperModel = (CategoryImportWrapperModel) unmarshaller.unmarshal(fileReader);


        fileReader.close();

        List<Category> listCategories = wrapperModel.getCategories()
                .stream()
                .map(c -> modelMapper.map(c, Category.class))
                .toList();

        this.categoryRepository.saveAll(listCategories);


    }

    @Override
    public void seedProducts() throws IOException, JAXBException {
        FileReader fileReader = new FileReader(PRODUCT_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(ProductImportWrapperModel.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        ProductImportWrapperModel productModel = (ProductImportWrapperModel) unmarshaller.unmarshal(fileReader);


        fileReader.close();

        List<Product> productList = productModel.getProducts()
                .stream()
                .map(model -> modelMapper.map(model, Product.class))
                .toList();

        List<Product> products = productList.stream()
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

