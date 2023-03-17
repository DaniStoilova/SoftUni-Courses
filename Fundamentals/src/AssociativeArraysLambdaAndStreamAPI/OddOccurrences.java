package AssociativeArraysLambdaAndStreamAPI;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            String word = input[i].toLowerCase();

            Integer value = countMap.get(word);
            if (countMap.containsKey(word)) {
                countMap.put(word, value + 1);
            } else {
                countMap.put(word, 1);

            }
        }
        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddWords.add(entry.getKey());
            }

        }
        System.out.println(String.join(", ", oddWords));
    }
}



