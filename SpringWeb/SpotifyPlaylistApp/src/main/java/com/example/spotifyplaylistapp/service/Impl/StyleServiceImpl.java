package com.example.spotifyplaylistapp.service.Impl;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.service.StyleService;
import org.springframework.stereotype.Service;

@Service
public class StyleServiceImpl implements StyleService {


    private StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }


    @Override
    public Style findStyleByStyleName(StyleEnum styleEnum) {
        return styleRepository.findByStyleName(styleEnum);
    }
}
