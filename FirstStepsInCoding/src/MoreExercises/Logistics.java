package MoreExercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        int priceBus = 0;
        int priceTrack = 0;
        int priceTrain = 0;
        int total = 0;
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        for (int i=1; i <= count; i++){
            int ton = Integer.parseInt(scanner.nextLine());
            total += ton;
            if (ton <= 3){
                    priceBus = 200;
                    t1 += ton;
            }else if(ton <= 11){
                    priceTrack = 175;
                    t2 += ton;
            }else if (ton >= 12){
                    priceTrain = 120;
                    t3 += ton;
                }

            }
            double totalPrice = (t1 * priceBus + t2 * priceTrack + t3 * priceTrain)* 1.0/total;
            System.out.printf("%.2f%n", totalPrice);
            System.out.printf("%.2f%%%n", t1 * 1.0/total * 100);
            System.out.printf("%.2f%%%n",t2 * 1.0/total * 100);
            System.out.printf("%.2f%%%n",t3 * 1.0/total * 100);

        }

    }

