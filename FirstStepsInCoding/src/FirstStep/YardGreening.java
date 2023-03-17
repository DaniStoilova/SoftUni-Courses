package FirstStep;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double area = Double.parseDouble(scanner.nextLine());
        // price 1 meter = 7.61

        double totalPrice = area * 7.61;
        double discount = totalPrice * 18/100;
        double finalPrice = totalPrice-discount;

        System.out.printf("The final price is: %.2f lv.%n The discount is: %.2f lv.",finalPrice, discount);


    }
}
