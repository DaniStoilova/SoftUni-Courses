package com.example.batteleship.init;

import com.example.batteleship.model.entity.Category;
import com.example.batteleship.model.enums.CategoryEnum;
import com.example.batteleship.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseInit  implements CommandLineRunner {


    private final CategoryRepository categoryRepository;

    public DatabaseInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() > 0){
            return;
        }
        Arrays.stream(CategoryEnum.values()).
                forEach(categoryEnum -> {
                    Category category = new Category();
                    category.setName(categoryEnum);
                    category.setDescription("");

                    categoryRepository.save(category);
                });



    }
}
