package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;

public interface StyleService {


    Style findStyleByStyleName(StyleEnum styleEnum);
}
