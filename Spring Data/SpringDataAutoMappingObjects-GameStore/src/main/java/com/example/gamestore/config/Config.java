package com.example.gamestore.config;

import com.example.gamestore.entities.Game;
import com.example.gamestore.model.GameAddDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        };
        modelMapper.addConverter(localDateConverter);
        modelMapper.typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper ->{
                    mapper.map(GameAddDto::getThubnailURL,
                            Game::setImageThumbnail);
                    mapper.using(localDateConverter).map(GameAddDto::getReleaseDate, Game::setReleaseDate);
                });


        return modelMapper;
    }
}
