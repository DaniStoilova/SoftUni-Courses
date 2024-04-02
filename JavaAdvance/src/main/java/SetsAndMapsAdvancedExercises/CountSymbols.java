package SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);


            if (!map.containsKey(symbol)) {

                map.put(symbol, 1);

            } else {
//            map.putIfAbsent(symbol,1);

                int value = map.get(symbol);

                map.put(symbol, value + 1);

            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }


    }
}
