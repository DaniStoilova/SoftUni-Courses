package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> shoppingList = Arrays
                .stream(scanner.nextLine().split("\\!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] command = input.split(" ");
            String commandLine = command[0];
            String product = command[1];


            switch (commandLine) {
                case "Urgent":
                    if (!shoppingList.contains(product)) {
                        shoppingList.add(0, product);
                    }
                    break;
                case "Unnecessary":
                    if (shoppingList.contains(product)) {
                        shoppingList.remove(product);
                    }
                    break;
                case "Correct":
                    String newItem = command[2];
                    if (shoppingList.contains(product)) {
                        int index = shoppingList.indexOf(product);
                        shoppingList.remove(product);
                        shoppingList.add(index, newItem);

                    }

                    break;
                case "Rearrange":
                    if (shoppingList.contains(product)) {
                        shoppingList.remove(product);
                        shoppingList.add(product);

                    }

                    break;
            }


            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", shoppingList));
    }


}
