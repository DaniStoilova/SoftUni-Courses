package IteratorsAndComparatorsExercises.ListyIterator.ListyIterator;

import java.util.List;

public class ListIterator {
    private List<String> elements;
    private int currentIndex;

    public ListIterator(String... elements) {
        this.elements =List.of(elements);
        currentIndex = 0;
    }
    public boolean hasNext(){
        return currentIndex < elements.size() -1;
    }
    public boolean move(){
        if (hasNext()){
            currentIndex++;
            return true;
        }
        return false;
    }
    public void print(){
        if (elements.isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(elements.get(currentIndex));
    }


}
