package IteratorsAndComparatorsExercises.StrategyPattern.StrategyPattern;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
            return first.getAge() - second.getAge();
    }
}
