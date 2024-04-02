package GenericsExercises.GenericSwapMethodInteger.GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void swap(int index1,int index2){
      //  Collections.swap(list,index1,index2);

        T temp = list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2,temp);

    }


    public void add(T element) {
        list.add(element);
    }

    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(String.format("%s: %s%n", t.getClass().getName(), t.toString()));
        }
        return sb.toString();
    }
}
