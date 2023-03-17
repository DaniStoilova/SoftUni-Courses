package FirstStep;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int quantityFoodDog = Integer.parseInt(scanner.nextLine());
        int quantityFoodCat = Integer.parseInt(scanner.nextLine());
        //food dog  - 2.50; food cat - 4


        double totalPrice = quantityFoodDog*2.50 + quantityFoodCat*4.0;
         System.out.printf("%.1f lv.",totalPrice);





    }
}
