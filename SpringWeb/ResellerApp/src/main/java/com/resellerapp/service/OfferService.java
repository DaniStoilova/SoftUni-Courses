package com.resellerapp.service;

import com.resellerapp.model.binding.AddOfferBindingModel;
import com.resellerapp.model.dto.BoughtDTO;
import com.resellerapp.model.dto.MyOfferDTO;
import com.resellerapp.model.dto.OtherDTO;
import com.resellerapp.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface OfferService {
    void addOffer(AddOfferBindingModel addOfferBindingModel);

    List<MyOfferDTO> getMyOffer(User user);

    List<OtherDTO> getOtherOffer(User created);

    List<BoughtDTO> getBought(User user);

    void buy(UUID id);

    void remove(UUID id);
}
