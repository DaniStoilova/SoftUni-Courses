package MidExam;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantityFoodInKilograms = Double.parseDouble(scanner.nextLine());
        double quantityHayInKilograms = Double.parseDouble(scanner.nextLine());
        double quantityCoverInKilograms = Double.parseDouble(scanner.nextLine());
        double guineaWeightInKilograms = Double.parseDouble(scanner.nextLine());

        int food = 300;
        int days = 30;
        double foodGram = quantityFoodInKilograms * 1000;
        double hayGram = quantityHayInKilograms * 1000;
        double coverGram = quantityCoverInKilograms * 1000;
        double weightGram = quantityFoodInKilograms * 100;
        for (int i = 1; i <= 30; i++) {

            foodGram -= food;

            if (i % 2 == 0) {

                hayGram -= foodGram * 0.05;

            }
            if (i % 3 == 0) {

                coverGram -= weightGram/ 3 ;
            }
            if (foodGram <= 0 || hayGram <= 0 || coverGram <= 0) {
                break;
            }
        }
        if (foodGram > 0 && hayGram > 0 && coverGram > 0){
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    foodGram/1000,hayGram/1000,coverGram/1000);
        }else if (foodGram <= 0 || hayGram <= 0 || coverGram <= 0){
            System.out.println("Merry must go to the pet store!");
        }

    }
}
