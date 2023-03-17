package exam;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countDays = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());

        double biscuit = 0;
        double dog = 0;
        double cat = 0;
        double total =0;
        for (int i = 1; i <= countDays; i++) {
            int foodDog = Integer.parseInt(scanner.nextLine());
            int foodCat = Integer.parseInt(scanner.nextLine());


            if (i % 3 == 0){
                biscuit += (foodDog+foodCat) * 0.10;
        }
            dog += foodDog;
            cat += foodCat;
            total = cat + dog;
        }


        System.out.printf("Total eaten biscuits: %.0fgr.%n%.2f%% of the food has been eaten.%n",biscuit, total / totalFood * 100);
        System.out.printf("%.2f%% eaten from the dog.%n", dog / total * 100);
        System.out.printf("%.2f%% eaten from the cat.%n", cat / total * 100);

    }
}

