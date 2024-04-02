package com.plannerapp.init;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final PriorityRepository priorityRepository;

    public DatabaseInit(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (priorityRepository.count() > 0) {
            return;
        }

            Arrays.stream(PriorityName.values())
                    .forEach(m->{
                        Priority priority = new Priority();

                        priority.setName(m);

                        switch (m){
                            case URGENT -> priority.setDescription("An urgent problem that blocks the system use until the issue is resolved.");
                            case IMPORTANT -> priority.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
                            case LOW -> priority.setDescription("Should be fixed if time permits but can be postponed.");
                        }

                        priorityRepository.save(priority);

                    });
        }

    }

