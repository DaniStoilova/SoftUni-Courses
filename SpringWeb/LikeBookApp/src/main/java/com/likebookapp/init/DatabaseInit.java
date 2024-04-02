package com.likebookapp.init;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodEnum;
import com.likebookapp.repository.MoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final MoodRepository moodRepository;

    public DatabaseInit(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if(moodRepository.count() > 0){
            return;
        }

        Arrays.stream(MoodEnum.values()).forEach(moodEnum -> {
            Mood mood = new Mood();
            mood.setMoodName(moodEnum);
            mood.setDescription("");

            moodRepository.save(mood);


        });


    }
}
