package com.example.coffe.init;


import com.example.coffe.model.entity.Category;
import com.example.coffe.model.enums.CategoryEnum;
import com.example.coffe.repository.CategoryRepository;
import com.example.coffe.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseInit implements CommandLineRunner {



   private final CategoryRepository categoryRepository;

    public DatabaseInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() > 0){
            return;
        }

        Arrays.stream(CategoryEnum.values())
                .forEach(c->{
                        Category category = new Category();
                        category.setName(c);
                        switch (c){
                            case Cake -> category.setNeededTime(10);
                            case Coffee -> category.setNeededTime(2);
                            case Drink -> category.setNeededTime(1);
                            case Other -> category.setNeededTime(5);
                        }

                        categoryRepository.save(category);
                });
    }
}
