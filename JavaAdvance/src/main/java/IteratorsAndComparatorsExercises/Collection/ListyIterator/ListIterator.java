package IteratorsAndComparatorsExercises.Collection.ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterable<String >{
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


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
         private int index ;
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public String next() {
                String element = elements.get(index);
                 index++;
                return element;
            }
        };
    }
    public void printAll(){
        String result = String.join(" ",elements);
        System.out.printf("%s%n",result);
    }
}
