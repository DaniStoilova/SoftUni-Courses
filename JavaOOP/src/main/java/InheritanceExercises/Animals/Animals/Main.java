package InheritanceExercises.Animals.Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String animalType = scanner.nextLine();

        while (!animalType.equals("Beast!")) {

            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data[2];


            try {
                switch (animalType) {
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        break;

                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }


            animalType = scanner.nextLine();

        }


    }
}
