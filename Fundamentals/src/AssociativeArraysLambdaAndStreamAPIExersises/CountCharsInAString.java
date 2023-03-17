package AssociativeArraysLambdaAndStreamAPIExersises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for (char symbol : text.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }
            if (!countMap.containsKey(symbol)) {
                countMap.put(symbol, 1);
            } else {
                int value = countMap.get(symbol);
                countMap.put(symbol, value + 1);
            }

        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());

        }


    }
}
