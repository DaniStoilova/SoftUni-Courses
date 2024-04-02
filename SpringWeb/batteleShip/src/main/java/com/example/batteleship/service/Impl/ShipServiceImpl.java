package com.example.batteleship.service.Impl;

import com.example.batteleship.model.binding.AddBindingModel;
import com.example.batteleship.model.entity.Category;
import com.example.batteleship.model.entity.Ship;
import com.example.batteleship.model.entity.User;
import com.example.batteleship.repository.CategoryRepository;
import com.example.batteleship.repository.ShipRepository;
import com.example.batteleship.repository.UserRepository;
import com.example.batteleship.service.ShipService;
import com.example.batteleship.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {

    private ShipRepository shipRepository;

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private CurrentUser currentUser;

    private CategoryRepository categoryRepository;



    public ShipServiceImpl(ShipRepository shipRepository, UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, CategoryRepository categoryRepository) {
        this.shipRepository = shipRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void confirmAdd(AddBindingModel addBindingModel) {
        Category category = categoryRepository.findByName(addBindingModel.getCategory());
        User user = userRepository.findByUsername(currentUser.getUsername());

        if (user != null || category != null){
            Ship ship = modelMapper.map(addBindingModel, Ship.class);

            ship.setCategory(category);
            ship.setUser(user);

            shipRepository.save(ship);
        }
    }

    @Override
    public List<Ship> findAllAttacker(Long id) {
        return shipRepository.findShipsByUser_Id(id);

//        this.shipRepository.findAllByUserId(id)
//                .orElseThrow()
//                .stream()
//                .map(ship -> this.modelMapper.map(ship, ShipModel.class))
//                .toList();

    }

    @Override
    public List<Ship> findAllDefender() {
        return shipRepository.findAllByUser_IdNot(currentUser.getId());
    }





}




