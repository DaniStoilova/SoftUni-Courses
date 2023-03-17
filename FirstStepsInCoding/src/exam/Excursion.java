package exam;

import java.util.Scanner;

public class Excursion {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int countSea = Integer.parseInt(scanner.nextLine());
        int countMountain = Integer.parseInt(scanner.nextLine());


        int price = 0;
        boolean isSold = false;
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String pack = input;
            if (pack.equals("sea")) {
                if (countSea > 0) {
                    price += 680;
                    countSea -= 1;
                }
            } else if (pack.equals("mountain")) {
                if (countMountain > 0) {
                    price += 499;
                    countMountain -= 1;
                }
            }
            input = scanner.nextLine();

            if (countSea <= 0 && countMountain <= 0) {
                isSold = true;
                break;
            }
        }

        if (isSold) {
            System.out.println("Good job! Everything is sold.");
        }
            System.out.printf("Profit: %d leva.",price);

        }

    }
