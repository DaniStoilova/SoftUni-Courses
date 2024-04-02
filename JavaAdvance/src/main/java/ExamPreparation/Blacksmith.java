package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelValue = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carbonValue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(carbonValue::push);

        Map<String, Integer> map = new HashMap<>();
        map.put("Gladius", 0);
        map.put("Shamshir", 0);
        map.put("Katana", 0);
        map.put("Sabre", 0);

        while (!steelValue.isEmpty() && !carbonValue.isEmpty()) {
            int steel = steelValue.peek();
            int carbon = carbonValue.peek();

            int sum = steel + carbon;

            steelValue.poll();
            carbonValue.pop();

            if (sum == 70) {
                int value = map.get("Gladius");
                map.put("Gladius", value + 1);
            } else if (sum == 80) {
                int value = map.get("Shamshir");
                map.put("Shamshir", value + 1);
            } else if (sum == 90) {
                int value = map.get("Katana");
                map.put("Katana", value + 1);
            } else if (sum == 110) {
                int value = map.get("Sabre");
                map.put("Sabre", value + 1);
            }else{
                carbon += 5;
                carbonValue.push(carbon);
            }
        }

        int result = map.values().stream().mapToInt(Integer::intValue).sum();

        if (result != 0) {
            System.out.printf("You have forged %d swords.%n", result);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steelValue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            List<String> listSteel = steelValue.stream().map(String::valueOf).collect(Collectors.toList());

            System.out.println("Steel left: " + String.join(", ", listSteel));

        }
        if (carbonValue.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            List<String> list = carbonValue.stream().map(String::valueOf).collect(Collectors.toList());

            System.out.println("Carbon left: " + String.join(", ", list));


        }

        map.entrySet().stream().sorted(Comparator.comparing(String::valueOf))
                .forEach(e -> {
                    if (e.getValue() > 0) {
                        System.out.println(e.getKey() + ": " + e.getValue());
                    }
                });

    }
}
