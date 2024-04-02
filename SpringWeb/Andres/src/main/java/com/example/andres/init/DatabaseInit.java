package com.example.andres.init;

import com.example.andres.model.entity.Category;
import com.example.andres.model.enums.CategoryEnum;
import com.example.andres.repo.CategoryRepository;
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

        if (categoryRepository.count() > 0) {
            return;
        }

        Arrays.stream(CategoryEnum.values())
                .forEach(c -> {
                    Category category = new Category();
                    category.setName(c);
                    category.setDescription("");

                    categoryRepository.save(category);
                });


    }
}
