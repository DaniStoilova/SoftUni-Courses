package FunctionalProgrammingLab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> people = sc -> {
            String[] input = sc.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            return new Person(name, age);
        };
        List<Person> personList = IntStream.range(0, n)
                .mapToObj(i -> people.apply(scanner))
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String printFormat = scanner.nextLine();

        Predicate<Person> ageFilter = getFilterAge(command, age);
        Consumer<Person> print = getPrint(printFormat);


        personList.stream().filter(ageFilter).forEach(print);

    }

    private static Consumer<Person> getPrint(String printFormat) {
        switch (printFormat) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("unknown printFormat" + printFormat);

        }
    }

    private static Predicate<Person> getFilterAge(String command, int age) {
        switch (command) {
            case "younger":
                return p -> p.age <= age;
            case "older":
                return p -> p.age >= age;
            default:
                throw new IllegalArgumentException("unknown command" + command);

        }

    }
}
