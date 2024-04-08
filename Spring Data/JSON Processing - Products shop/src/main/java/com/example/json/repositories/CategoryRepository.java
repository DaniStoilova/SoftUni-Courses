package com.example.json.repositories;
import com.example.json.entities.Category;
import com.example.json.models.CategorySummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT new com.example.json.models.CategorySummaryDTO" +
            "(c.name, COUNT(p.id), AVG(p.price), SUM(p.price))" +
            " FROM Product p " +
            " JOIN p.categories c" +
            " GROUP BY c.id" +
            " ORDER BY COUNT(p.id) DESC")
    List<CategorySummaryDTO> getCategorySummary();




}
