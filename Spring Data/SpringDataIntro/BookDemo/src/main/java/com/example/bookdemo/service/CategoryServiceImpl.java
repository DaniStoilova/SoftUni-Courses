package com.example.bookdemo.service;

import com.example.bookdemo.Entity.Category;
import com.example.bookdemo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {


    private static final String PATH = "src/main/resources/files/categories.txt";

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0){
            return;
        }

        Files.readAllLines(Path.of(PATH))
                .stream()
                .filter(line-> !line.isEmpty())
                .forEach(name->{
                    Category category = new Category();

                    category.setName(name);

                    categoryRepository.save(category);
                });

    }

    @Override
    public Set<Category> getRandomCategories() {

        Set<Category> categories = new HashSet<>();

        int random = ThreadLocalRandom.current().nextInt(1,3);

        for (int i = 0; i < random; i++) {

        long id = ThreadLocalRandom.current().nextLong(1,categoryRepository.count() + 1);

            Category category = categoryRepository.findById(id).orElse(null);

            categories.add(category);

        }

        return categories;
    }
}
