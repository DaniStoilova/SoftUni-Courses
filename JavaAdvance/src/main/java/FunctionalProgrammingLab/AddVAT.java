package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double[] numbers = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleUnaryOperator vat = p -> p * 1.20;

        Consumer<double[]> print = p -> {
            System.out.println("Prices with VAT:");
            System.out.println(Arrays.stream(p)
                    .map(vat)
                    .mapToObj(d -> String.format("%.2f", d))
                    .collect(Collectors.joining(System.lineSeparator())));


        };
        print.accept(numbers);


    }
}
