package com.example.shoppinglist.init;

import com.example.shoppinglist.model.entity.Category;
import com.example.shoppinglist.model.enums.CategoryEnum;
import com.example.shoppinglist.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class DataBaseInit implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    public DataBaseInit(CategoryRepository categoryRepository) {
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
                        category.setDescription("");

                        categoryRepository.save(category);


                });
    }
}

