package IteratorsAndComparatorsExercises.ComparingObjects.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> list = new ArrayList<>();

        while (!input.equals("END")) {
            String[] people = input.split(" ");
            String name = people[0];
            int age = Integer.parseInt(people[1]);
            String town = people[2];

            Person person = new Person(name, age, town);


            list.add(person);

            input = scanner.nextLine();
        }
        int namePersonIndex = Integer.parseInt(scanner.nextLine());

        int samePeople = 0;
        int differentPeople = 0;

        Person mainPerson = list.get(namePersonIndex - 1);



        for (Person person : list) {
            if (person.compareTo(mainPerson) == 0) {
                samePeople++;
            } else {
                differentPeople++;
            }
        }
        if (samePeople == 1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d%n", samePeople, differentPeople, list.size());
        }
    }
}
