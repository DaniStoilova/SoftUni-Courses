package ListExersises;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> distance = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sumRemoved = 0;
        while (distance.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                int firstEl = distance.get(0);
                sumRemoved += firstEl;
                int lastEl = distance.get(distance.size() - 1);
                distance.set(0, lastEl);
                modifyList(distance, firstEl);


            } else if (index > distance.size() -1) {
                int firstEl = distance.get(0);
                int lastEl = distance.get(distance.size() - 1);
                sumRemoved += lastEl;
                distance.set(distance.size() - 1, firstEl);
                modifyList(distance, lastEl);


            } else if (index >= 0 && index <= distance.size() - 1) {
                int removeIndex = distance.get(index);
                sumRemoved += removeIndex;
                distance.remove(index);
                modifyList(distance, removeIndex);
            }


        }
        System.out.println(sumRemoved);


    }

    private static void modifyList(List<Integer> list, int removeEl) {
        for (int index = 0; index <= list.size() - 1; index++) {
            int currentElement = list.get(index);
            if (currentElement <= removeEl) {
                currentElement += removeEl;
            } else {
                currentElement -= removeEl;
            }
            list.set(index, currentElement);
        }
    }
}
