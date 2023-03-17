package WhileLoop;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededMoneyTrip = Double.parseDouble(scanner.nextLine());
        double ownedMoney = Double.parseDouble(scanner.nextLine());


        int spendDays = 0;
        int countDays = 0;
        while (ownedMoney < neededMoneyTrip) {
            if (spendDays == 5) {
                break;

            }
            String action = scanner.nextLine();
            double amount = Double.parseDouble(scanner.nextLine());

            countDays++;

            if (action.equals("save")) {
                ownedMoney += amount;
                spendDays = 0;
            } else {
                spendDays++;
                ownedMoney -= amount;

                if (ownedMoney < 0) {
                    ownedMoney = 0;
                }
            }
        }

        if (spendDays == 5) {
            System.out.println("You can't save the money.");
            System.out.println(countDays);
        } else {
            System.out.printf("You saved the money for %d days.", countDays);
        }
    }
}

