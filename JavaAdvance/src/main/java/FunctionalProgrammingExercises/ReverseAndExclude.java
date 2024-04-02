package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int numRemove = Integer.parseInt(scanner.nextLine());


        Collections.reverse(list);

        list.removeIf(number -> number % numRemove == 0);

        list.forEach(e -> System.out.print(e + " "));


    }
}
