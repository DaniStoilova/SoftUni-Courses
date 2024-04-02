package com.resellerapp.service.Impl;

import com.resellerapp.model.binding.AddOfferBindingModel;
import com.resellerapp.model.dto.BoughtDTO;
import com.resellerapp.model.dto.MyOfferDTO;
import com.resellerapp.model.dto.OtherDTO;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.model.helper.CurrentUser;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.ConditionService;
import com.resellerapp.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;

    private UserRepository userRepository;

    private ConditionRepository conditionRepository;

    private ModelMapper modelMapper;

    private ConditionService conditionService;

    private CurrentUser currentUser;

    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository, ConditionRepository conditionRepository, ModelMapper modelMapper, ConditionService conditionService, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.conditionRepository = conditionRepository;
        this.modelMapper = modelMapper;
        this.conditionService = conditionService;
        this.currentUser = currentUser;
    }

    @Override
    public void addOffer(AddOfferBindingModel addOfferBindingModel) {

        Condition condition = conditionRepository.findByName(addOfferBindingModel.getCondition());
        User user = userRepository.findByUsername(currentUser.getUsername());


        if (user != null || condition != null){
            Offer offer = modelMapper.map(addOfferBindingModel,Offer.class);
            offer.setCondition(condition);
            offer.setCreated(user);

            offerRepository.save(offer);

        }

    }

    @Override
    public List<MyOfferDTO> getMyOffer(User user) {
        return offerRepository
                .findAllByCreated(user)
                .stream()
                .map(m->modelMapper
                        .map(m,MyOfferDTO.class)).collect(Collectors.toList());

    }

    @Override
    public List<OtherDTO> getOtherOffer(User created) {
        List<Offer> allNull = offerRepository.findAllByCreatedNot(created);


        return getUsernameAndOther(allNull);
    }

    @Override
    public List<BoughtDTO> getBought(User user) {


        return offerRepository.findAllByBought(user)
                .stream()
                .map(b->modelMapper.map(b,BoughtDTO.class))
                .collect(Collectors.toList());
    }

    private List<OtherDTO> getUsernameAndOther(List<Offer> allNull) {

        return allNull.stream().map(e ->
                modelMapper.map(e,OtherDTO.class)
                        .setUsername(e.getCreated().getUsername())).collect(Collectors.toList());

//        return allNull.stream().map(e -> {
//        OtherDTO currentDTO = new OtherDTO();
//        currentDTO.setDescription(e.getDescription());
//        currentDTO.setCondition(e.getCondition());
//        currentDTO.setPrice(e.getPrice());
//        currentDTO.setUsername(e.getCreated().getUsername());
//
//        return currentDTO;
//        })
//        .collect(Collectors.toList());


    }

    @Override
    public void buy(UUID id) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);

        if (optionalOffer.isPresent()) {
            User user = userRepository.findByUsername(currentUser.getUsername());
            Offer offer = optionalOffer.get();

            offer.setBought(user);

            offerRepository.save(offer);


        }
    }

    @Override
    public void remove(UUID id) {
        offerRepository.deleteById(id);
    }
}


