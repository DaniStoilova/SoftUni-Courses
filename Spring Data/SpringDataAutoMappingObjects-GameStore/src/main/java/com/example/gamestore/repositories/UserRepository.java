package com.example.gamestore.repositories;

import com.example.gamestore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findFirstByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
