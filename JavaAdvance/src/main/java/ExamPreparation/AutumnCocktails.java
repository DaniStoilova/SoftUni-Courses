package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bucket = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(freshness::push);

        Map<String, Integer> map = new HashMap<>();
        map.put("Pear Sour", 0);
        map.put("The Harvest", 0);
        map.put("Apple Hinny", 0);
        map.put("High Fashion", 0);

        while (!bucket.isEmpty() && !freshness.isEmpty()) {
            int first = bucket.peek();
            int second = freshness.peek();
            if (first == 0) {
                bucket.poll();
                continue;
            }
            int sum = first * second;

            bucket.poll();
            freshness.pop();

            if (sum == 150) {
                int value = map.get("Pear Sour");
                map.put("Pear Sour", value + 1);

            } else if (sum == 250) {
                int value = map.get("The Harvest");
                map.put("The Harvest", value + 1);

            } else if (sum == 300) {
                int value = map.get("Apple Hinny");
                map.put("Apple Hinny", value + 1);

            } else if (sum == 400) {
                int value = map.get("High Fashion");
                map.put("High Fashion", value + 1);
            } else {
                first += 5;
                bucket.addLast(first);
            }


        }
        int result = map.values().stream().mapToInt(Integer::intValue).sum();

        if (result >= 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!bucket.isEmpty()) {
            int sum = 0;
            for (Integer integer : bucket) {
                sum += integer;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }
        map.entrySet().stream().sorted(Comparator.comparing(String::valueOf))
                .forEach(s -> {
                    if (s.getValue() > 0) {
                        System.out.println("# " + s.getKey() + " --> " + s.getValue());
                    }
                });


    }
}
