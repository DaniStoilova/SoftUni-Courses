package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Function<int[], String> count = el -> "Count" + " = " + Arrays.stream(el).count();
        Function<int[], String> sum = element -> "Sum" + " = " + Arrays.stream(element).sum();

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();


        System.out.println(count.apply(numbers));
        System.out.println(sum.apply(numbers));


    }
}
