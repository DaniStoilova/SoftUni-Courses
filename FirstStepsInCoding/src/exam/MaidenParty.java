package exam;

import java.util.Scanner;

public class MaidenParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Любовно послание - 0.60 лв.
        //•	Восъчна роза - 7.20 лв.
        //•	Ключодържател - 3.60 лв.
        //•	Карикатура - 18.20 лв.
        //•	Късмет изненада - 22 лв.
        double priceParty = Double.parseDouble(scanner.nextLine());
        int countLoveMessage = Integer.parseInt(scanner.nextLine());
        int countRoses = Integer.parseInt(scanner.nextLine());
        int countCase = Integer.parseInt(scanner.nextLine());
        int countPicture = Integer.parseInt(scanner.nextLine());
        int countLucky = Integer.parseInt(scanner.nextLine());


        double sum = countLoveMessage * 0.60 + countRoses * 7.20 + countCase * 3.60
                + countPicture * 18.20 + countLucky * 22;

        double countArtikul = countLoveMessage + countRoses + countCase + countPicture + countLucky;
        if (countArtikul >= 25) {
            sum = sum * 0.65;
        }

        double profit = sum * 0.90;

        double totalSum = Math.abs(profit - priceParty);

        if (totalSum > priceParty) {
            System.out.printf("Yes! %.2f lv left.", totalSum);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.",totalSum);
        }


    }
}
