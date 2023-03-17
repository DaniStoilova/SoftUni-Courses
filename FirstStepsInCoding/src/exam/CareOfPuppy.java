package exam;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int countFood = Integer.parseInt(scanner.nextLine());

        int totalGram = countFood * 1000;
        int total = 0;
        String input = scanner.nextLine();

        while (!input.equals("Adopted")){
            int gramFood = Integer.parseInt(input);
            total += gramFood;

            input = scanner.nextLine();
        }
        if (total <= totalGram){
            System.out.printf("Food is enough! Leftovers: %d grams.", Math.abs(total - totalGram));
        }else{
            System.out.printf("Food is not enough. You need %d grams more.",Math.abs(total - totalGram));
        }
    }
}
