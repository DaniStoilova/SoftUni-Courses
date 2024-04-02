package FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> guests = Arrays
                .stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Set<String> filter = new HashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("Print")) {
            String[] command = input.split(";");
            String addOrRemove = command[0];
            String parts = command[1];
            String parameter = command[2];

            if (addOrRemove.equals("Add filter")) {
                filter.add(parts + ";" + parameter);
            } else {
                filter.remove(parts + ";" + parameter);
            }

            input = scanner.nextLine();
        }
        filter.forEach(filters -> {

            Predicate<String> predicate = getPredicate(filters);
            guests.removeIf(predicate);


        });

        guests.forEach(e -> System.out.print(e + " "));
    }

    private static Predicate<String> getPredicate(String filter) {
        String[] parts = filter.split(";");
        String type = parts[0];
        String parameter = parts[1];

        switch (type) {
            case "Starts with":
                return e -> e.startsWith(parameter);
            case "Ends with":
                return e -> e.endsWith(parameter);
            case "Length":
                return e -> e.length() == Integer.parseInt((parameter));
            case "Contains":
                return e -> e.contains(parameter);
        }
        return null;
    }
}

