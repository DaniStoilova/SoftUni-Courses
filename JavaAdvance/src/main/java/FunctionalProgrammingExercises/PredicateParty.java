package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guest = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();


        while (!input.equals("Party!")) {

            String[] command = input.split("\\s");
            String doubleOrRemove = command[0];
            String type = command[1];
            String parameter = command[2];

            Predicate<String> predicate = getPredicate(type, parameter);

            if (doubleOrRemove.equals("Double")) {
                for (int i = 0; i < guest.size(); i++) {
                    String name = guest.get(i);
                    if (getPredicate(type, parameter).test(name)) {
                        guest.add(i++, name);
                    }
                }
            } else {
                guest.removeIf(getPredicate(type, parameter));

            }

            input = scanner.nextLine();
        }
        if (guest.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guest);
            System.out.println(String.format("%s are going to the party!", String.join(", ", guest)));
        }


    }

    private static Predicate<String> getPredicate(String t, String p) {
        switch (t) {
            case "StartsWith":
                return e -> e.startsWith(p);
            case "EndsWith":
                return e -> e.endsWith(p);
            case "Length":
                return e -> e.length() == Integer.parseInt((p));
            default:
                return e -> false;
        }
    }
}
