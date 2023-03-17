package MoreExercises;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double heritage = Double.parseDouble(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());


        int age = 0;
        double money = 0;
        for (int i=1800; i <= year; i++){
            if (i % 2 == 0){
                if (i == 1800) {
                    money = heritage - 12000;
                    age = 18;
                }else {
                    money = money - 12000;
                    age += 1;
                }
            }else{
                age += 1;
                money =money - (12000 + age * 50);
            }
            }
            if (money >= 0 ) {

                System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", money);
            }else{
                System.out.printf("He will need %.2f dollars to survive.", Math.abs(money));
            }



    }
}
