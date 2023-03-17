package ListExersises;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

       List<String> numbers =Arrays.stream(input.split("\\|")).collect(Collectors.toList());

        //Collections.sort(numbers);
        Collections.reverse(numbers);

        System.out.println(numbers.toString().replaceAll("[\\[\\],]","")
                .replaceAll("\\s +"," "));


    }
}
