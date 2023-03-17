package exam;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int minWalkingDay = Integer.parseInt(scanner.nextLine());
        int cost = Integer.parseInt(scanner.nextLine());
        int calories = Integer.parseInt(scanner.nextLine());


        int totalMinWalking = minWalkingDay * cost;
        int totalCaloriesWalking = totalMinWalking * 5;
        double totalCaloriesPerDay = calories * 0.5;

        if (totalCaloriesWalking >= totalCaloriesPerDay){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", totalCaloriesWalking);
        }else{
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.",totalCaloriesWalking );

        }

    }
}
