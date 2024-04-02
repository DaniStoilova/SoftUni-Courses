package DefiningClassesExercises.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split(" ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person person = new Person(name, age);
            personList.add(person);
        }

        personList.stream().filter(person -> person.getAge() > 30)
                .sorted((first, second) -> first.getName().compareTo(second.getName()))
                .forEach(System.out::println);


    }
}
