package com.example.batteleship.repository;

import com.example.batteleship.model.entity.Category;
import com.example.batteleship.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(CategoryEnum category);
}
