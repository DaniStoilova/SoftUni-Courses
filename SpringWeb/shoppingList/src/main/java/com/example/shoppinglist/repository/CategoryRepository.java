package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.entity.Category;
import com.example.shoppinglist.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(CategoryEnum categoryEnum);
}