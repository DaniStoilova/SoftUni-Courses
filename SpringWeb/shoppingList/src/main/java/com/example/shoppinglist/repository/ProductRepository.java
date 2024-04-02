package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.binding.ProductDTO;
import com.example.shoppinglist.model.entity.Product;
import com.example.shoppinglist.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByCategory_Name(CategoryEnum categoryEnum);

    @Query("SELECT SUM(p.price) FROM Product p ")
    BigDecimal findAllByPrice();
}
