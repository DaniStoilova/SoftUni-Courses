package MoreExercises;

import java.util.Scanner;

public class tank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String petrol = scanner.nextLine();
        double petrolLitre = Double.parseDouble(scanner.nextLine());

        switch (petrol) {
            case "diesel":
            case "gasoline":
            case "gas":
                break;
        }
        if (petrolLitre < 25) {
            System.out.printf("Fill your tank with %s!", petrol);
        } else if (petrolLitre >= 25) {
            System.out.printf("You have enough %s.", petrol);
        } else {
            System.out.println("Invalid fuel!");

        }
    }
    }



