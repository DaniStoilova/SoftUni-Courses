package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Double> milkValue = Arrays.stream(scanner.nextLine()
                        .split(" ")).map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacaoValue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .forEach(cacaoValue::push);

        Map<String, Integer> chocolate = new HashMap<>();
        chocolate.putIfAbsent("Milk Chocolate", 0);
        chocolate.put("Dark Chocolate", 0);
        chocolate.put("Baking Chocolate", 0);

        boolean isMilk = false;
        boolean isDark = false;
        boolean isBaking = false;

        while (!milkValue.isEmpty() && !cacaoValue.isEmpty()) {
            double milk = milkValue.peek();
            double cacao = cacaoValue.peek();

            double percentage = cacao / (cacao + milk) * 100;

            if (percentage != 30 && percentage != 50 && percentage != 100) {
                milkValue.poll();
                cacaoValue.pop();
            } else {
                cacaoValue.pop();
                milk += 10;
                milkValue.poll();
                milkValue.addLast(milk);
            }

            if (percentage == 30) {
                int value = chocolate.get("Milk Chocolate");
                chocolate.put("Milk Chocolate", value + 1);

                isMilk = true;

            } else if (percentage == 50) {
                int value = chocolate.get("Dark Chocolate");
                chocolate.put("Dark Chocolate", value + 1);
                isDark = true;

            } else if (percentage == 100) {
                int value = chocolate.get("Baking Chocolate");
                chocolate.put("Baking Chocolate", value + 1);

                isBaking = true;
            }

        }
        if (isMilk && isBaking && isDark) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");

        }

        chocolate.entrySet().stream().sorted(Comparator.comparing(String::valueOf))
                .forEach(s -> {
                    if (s.getValue() > 0) {
                        System.out.printf("# %s --> %d%n", s.getKey(), s.getValue());

                    }
                });

    }
}
