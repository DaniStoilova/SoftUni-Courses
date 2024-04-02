package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer numberToDivide : list) {
                if (number % numberToDivide != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1,num).boxed()
                .filter(isDivisible).forEach(number ->System.out.print(number + " "));


//        for (int i = 1; i <= num; i++) {
//            if (isDivisible.test(i)) {
//                System.out.print(i + " ");
//            }
//        }


    }
}
