package com.example.andres.service.Impl;

import com.example.andres.model.binding.AddItemBindingModel;
import com.example.andres.model.binding.ItemDTO;
import com.example.andres.model.entity.Category;
import com.example.andres.model.entity.Item;
import com.example.andres.model.entity.User;
import com.example.andres.model.helper.CurrentUser;
import com.example.andres.repo.CategoryRepository;
import com.example.andres.repo.ItemRepository;
import com.example.andres.repo.UserRepository;
import com.example.andres.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private CategoryRepository categoryRepository;


    private ItemRepository itemRepository;

    private UserRepository userRepository;

    private CurrentUser currentUser;

    private ModelMapper modelMapper;

    public ItemServiceImpl(CategoryRepository categoryRepository, ItemRepository itemRepository, UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }


    @Override
    public void confirm(AddItemBindingModel addItemBindingModel) {
        Category category = categoryRepository.findByName(addItemBindingModel.getCategory());
        User user = userRepository.findByUsername(currentUser.getUsername());


        if (user != null || category != null) {
            Item item = modelMapper.map(addItemBindingModel, Item.class);
            item.setCategory(category);

            itemRepository.save(item);

        }

    }

    @Override
    public List<ItemDTO> getAll() {
        return itemRepository
                .findAll()
                .stream()
                .map(m -> {
                    ItemDTO itemDTO = modelMapper.map(m,ItemDTO.class);

                    itemDTO.setUrl(String.format
                                    ("/img/%s-%s.jpg",
                                            m.getGenre(), m.getCategory().getName().name()));

                    return itemDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO findById(Long id) {
        return itemRepository
                .findById(id)
                .map(m -> {
                    ItemDTO itemDTO = modelMapper.map(m,ItemDTO.class);

                    itemDTO.setUrl(String.format
                            ("/img/%s-%s.jpg",
                                    m.getGenre(), m.getCategory().getName().name()));

                    return itemDTO;
                }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
