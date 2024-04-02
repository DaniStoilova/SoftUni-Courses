package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt)
                .toArray();

//        Function<int[], Integer> function = (int[] arr) -> {
//            int min = Integer.MAX_VALUE;
//            for (int num : arr) {
//                if (min > num) {
//                    min = num;
//                }
//            }
//            return min;
//
//
//        };

        Function<int[], Integer> min  = e -> Arrays.stream(e).min().orElseThrow(() -> new IllegalArgumentException());
        //Function<int[],Integer> min = e -> Collections.min(Arrays.stream(e).boxed().collect(Collectors.toList()));

        System.out.println(min.apply(numbers));

    }


}
