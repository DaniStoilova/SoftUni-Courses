package com.example.andres.repo;

import com.example.andres.model.entity.Category;
import com.example.andres.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(CategoryEnum category);
}
