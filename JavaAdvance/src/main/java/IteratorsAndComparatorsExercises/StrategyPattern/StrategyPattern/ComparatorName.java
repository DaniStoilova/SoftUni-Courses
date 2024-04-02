package IteratorsAndComparatorsExercises.StrategyPattern.StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class ComparatorName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if (first.getName().length() == (second.getName().length())) {
            char letterFirst = first.getName().toLowerCase().charAt(0);
            char letterSecond = second.getName().toLowerCase().charAt(0);
            return Character.compare(letterFirst,letterSecond);
        }
        return first.getName().length() - (second.getName().length());
    }
}
