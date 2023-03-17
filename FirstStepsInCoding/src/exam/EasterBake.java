package exam;

import java.util.Scanner;

public class EasterBake {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        int packSugar = 950;
        int packFlour = 750;
        int sugarSum = 0;
        int flourSum = 0;
        int maxSugar = Integer.MIN_VALUE;
        int maxFlour = Integer.MIN_VALUE;
        double countSugar = 0;
        double countFlour = 0;
        for (int i=1; i <= count; i++){
            int sugar = Integer.parseInt(scanner.nextLine());
            int flour = Integer.parseInt(scanner.nextLine());

            sugarSum += sugar;
            flourSum += flour;



            if (maxSugar <= sugar){
                maxSugar = sugar;
            }
            if (maxFlour <= flour){
                maxFlour = flour;
            }

        }
        countSugar =Math.ceil(sugarSum * 1.0/packSugar);
        countFlour =Math.ceil (flourSum * 1.0/packFlour);


        System.out.printf("Sugar: %.0f%n",countSugar);
        System.out.printf("Flour: %.0f%n",countFlour);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.",maxFlour, maxSugar);

    }
}
