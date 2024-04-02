package com.likebookapp.service;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodEnum;

public interface MoodService {
    Mood findByMoodName(MoodEnum mood);
}
