package com.example.json.repositories;
import com.example.json.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   List<User> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName();

   @Query("SELECT u " +
           "FROM User u " +
           "JOIN u.soldProducts p " +
           "WHERE p.buyer IS NOT NULL " +
           "order by size(u.soldProducts) DESC, u.lastName ")
  List<User> usersAndProducts();


}
