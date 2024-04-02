package com.resellerapp.init;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionEnum;
import com.resellerapp.repository.ConditionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ConditionRepository conditionRepository;

    public DatabaseInit(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if(conditionRepository.count() > 0){
            return;
        }
        Arrays.stream(ConditionEnum.values()).forEach(con->{
            Condition condition = new Condition();
            condition.setName(con);
            switch (con){
                case GOOD: condition.setDescription("Some signs of wear and tear or minor defects");
                case EXCELLENT:condition.setDescription("In perfect condition");
                case ACCEPTABLE:condition.setDescription("The item is fairly worn but continues to function properly");
            }

            conditionRepository.save(condition);

        });

    }
}
