package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Arrays;

@Component
public class DataBaseInit implements CommandLineRunner {



    private StyleRepository styleRepository;

    public DataBaseInit(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if (styleRepository.count() > 0){
            return;
        }

        Arrays.stream(StyleEnum.values())
                .forEach(s->{
                    Style style = new Style();
                    style.setStyleName(s);
                    style.setDescription("");

                    styleRepository.save(style);

                });



    }
}
