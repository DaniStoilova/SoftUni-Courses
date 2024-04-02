package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Pastryshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquid = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> ingredient = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredient::push);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Biscuit", 0);
        map.put("Cake", 0);
        map.put("Pie", 0);
        map.put("Pastry", 0);

        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        while (!liquid.isEmpty() && !ingredient.isEmpty()) {
            int first = liquid.peek();
            int second = ingredient.peek();

            int sum = first + second;

            liquid.poll();
            ingredient.pop();

            if (sum == 25) {
                int value = map.get("Biscuit");
                map.put("Biscuit", value + 1);
                count++;

            } else if (sum == 50) {
                int value = map.get("Cake");
                map.put("Cake", value + 1);
                count1++;

            } else if (sum == 75) {
                int value = map.get("Pastry");
                map.put("Pastry", value + 1);
                count2++;
            } else if (sum == 100) {
                int value = map.get("Pie");
                map.put("Pie", value + 1);
                count3++;

            } else {
                second += 3;
                ingredient.push(second);

            }

        }
        //int result = map.values().stream().mapToInt(Integer::intValue).sum();

        if (count != 0 && count1 != 0 && count2 != 0 && count3 != 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquid.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> listLiquid = liquid.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println("Liquids left: " + String.join(", ", listLiquid));
        }
        if (ingredient.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> list = ingredient.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println("Ingredients left: " + String.join(", ", list));
        }


        map.entrySet().stream().forEach(s ->
                System.out.println(s.getKey() + ": " + s.getValue()));


    }
}
