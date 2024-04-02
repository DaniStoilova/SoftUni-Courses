package com.resellerapp.repository;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {

    List<Offer> findAllByCreated(User created);
    List<Offer> findAllByCreatedNot(User created);

    List<Offer> findAllByBought(User bought);
}
