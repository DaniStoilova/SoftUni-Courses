package com.example.batteleship.repository;

import com.example.batteleship.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {
    List<Ship> findShipsByUser_Id(Long id);

    List<Ship> findAllByUser_IdNot(Long user_id);


}
