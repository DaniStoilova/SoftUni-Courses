package exam;

import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        String packet = scanner.nextLine();
        String vip = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        double price = 0;
        if (city.equals("Bansko") || city.equals("Borovets")) {
            if (packet.equals("withEquipment")) {
                price = 100;
                if (vip.equals("yes")) {
                    price = price * 0.90;
                } else if (vip.equals("no")) {
                }
            } else if (packet.equals("noEquipment")) {
                price = 80;
                if (vip.equals("yes")) {
                    price = price * 0.95;
                } else if (vip.equals("no")) {
                }
            } else {
                isFound = true;
            }
        } else if (city.equals("Varna") || city.equals("Burgas")) {
            if (packet.equals("withBreakfast")) {
                price = 130;
                if (vip.equals("yes")) {
                    price = price * 0.88;
                } else if (vip.equals("no")) {

                }
            } else if (packet.equals("noBreakfast")) {
                price = 100;
                if (vip.equals("yes")) {
                    price = price * 0.93;
                } else if (vip.equals("no")) {

                }

            } else {
                isFound = true;
            }


        }else{
            isFound = true;
        }

            double total = days * price;
        if(isFound) {
            System.out.println("Invalid input!");
        }else if (days == 0) {
                System.out.println("Days must be positive number!");
        } else {
                System.out.printf("The price is %.2flv! Have a nice time!", total);
        }

    }
}


