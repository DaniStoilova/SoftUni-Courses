package exam;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int place = Integer.parseInt(scanner.nextLine());


        int price = 0;
        String input = scanner.nextLine();
        while (!input.equals("Movie time!")) {
            int countPeople = Integer.parseInt(input);

            int diff = place - countPeople;
            if (diff >= 0) {
                place -= countPeople;
                price += countPeople * 5;
                if (countPeople % 3 == 0) {
                    price -= 5;
                }

                } else {
                    break;
                }
                input = scanner.nextLine();
            }
            if (input.equals("Movie time!")) {
                System.out.printf("There are %d seats left in the cinema.%n", place);
                System.out.printf("Cinema income - %d lv.%n", price);
            } else {
                System.out.println("The cinema is full.");
                System.out.printf("Cinema income - %d lv.%n", price);
            }
        }
    }

