package EncapsulationLab.ValidationData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner  scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people  = new ArrayList<>();
        //Team team = new Team("Black Eagles");

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            double salary = Double.parseDouble(data[3]);

            Optional<Person> person = Optional.empty();

            try {
                person = Optional.of(new Person(firstName, lastName, age, salary));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            person.ifPresent(people::add);
        }
            double bonus = Double.parseDouble(scanner.nextLine());

            for (Person person1 : people) {
                person1.increaseSalary(bonus);
                System.out.println(person1.toString());
            }




//            team.addPlayer(person);
//
//        }
//        System.out.println("First team have " + team.getFirstTeam().size() + " players");
//        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");


        }
    }

