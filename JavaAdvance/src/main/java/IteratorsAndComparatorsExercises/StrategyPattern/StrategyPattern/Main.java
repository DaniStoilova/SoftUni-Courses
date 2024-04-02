package IteratorsAndComparatorsExercises.StrategyPattern.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<Person> nameSet = new TreeSet<>(new ComparatorName());
        TreeSet<Person> ageSet= new TreeSet<>(new ComparatorAge());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name,age);

            nameSet.add(person);
            ageSet.add(person);

        }

        for (Person person : nameSet) {
            System.out.println(person);
        }
        for (Person person : ageSet) {
            System.out.println(person);
        }






    }
}
