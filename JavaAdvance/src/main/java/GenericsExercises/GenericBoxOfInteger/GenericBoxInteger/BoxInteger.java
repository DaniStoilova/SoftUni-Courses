package GenericsExercises.GenericBoxOfInteger.GenericBoxInteger;

import java.util.ArrayList;
import java.util.List;

public class BoxInteger <T>{
        private List<T> list;

        public BoxInteger() {
            this.list = new ArrayList<>();
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


