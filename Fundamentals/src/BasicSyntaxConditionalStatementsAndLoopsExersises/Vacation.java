package BasicSyntaxConditionalStatementsAndLoopsExersises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double price = 0.0;
        if (dayOfWeek.equals("Friday")) {
            if (typeOfGroup.equals("Students")) {
                price = 8.45;
                if (groupPeople >= 30) {
                    price = price * 0.85;
                }
            } else if (typeOfGroup.equals("Business")) {
                price = 10.90;
            } else if (typeOfGroup.equals("Regular")) {
                price = 15;
                if (groupPeople >= 10 && groupPeople <= 20) {
                    price = price * 0.95;
                }
            }

        } else if (dayOfWeek.equals("Saturday")) {
            if (typeOfGroup.equals("Students")) {
                price = 9.80;
                if (groupPeople >= 30) {
                    price = price * 0.85;
                }
            } else if (typeOfGroup.equals("Business")) {
                price = 15.60;
            } else if (typeOfGroup.equals("Regular")) {
                price = 20;
                if (groupPeople >= 10 && groupPeople <= 20) {
                    price = price * 0.95;
                }
            }

        } else if (dayOfWeek.equals("Sunday")) {
            if (typeOfGroup.equals("Students")) {
                price = 10.46;
                if (groupPeople >= 30) {
                    price = price * 0.85;
                }
            } else if (typeOfGroup.equals("Business")) {
                price = 16;
            } else if (typeOfGroup.equals("Regular")) {
                price = 22.50;
                if (groupPeople >= 10 && groupPeople <= 20) {
                    price = price * 0.95;
                }
            }

        }

        double priceTotal = price * groupPeople;

        if (typeOfGroup.equals("Business") && groupPeople >= 100){
            price = price * 10;
            priceTotal = priceTotal - price;
        }

        System.out.printf("Total price: %.2f",priceTotal);

    }
}
