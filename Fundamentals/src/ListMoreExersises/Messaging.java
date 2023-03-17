package ListMoreExersises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> text = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());


        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            int sum = 0;

            while (num > 0) {
                int lastDigit = num % 10;
                sum += lastDigit;
                num = num / 10;
            }
            for (int j = 1; j <= text.size() -1; j++) {
                if (j == sum) {
                    System.out.print(text.get(j));
                    text.remove(j);
                    break;
                } else if (sum > text.size() - 1) {
                    sum = 0;
                    System.out.print(text.get(j));
                    text.remove(j);
                    break;
                }
            }

        }
    }

}



