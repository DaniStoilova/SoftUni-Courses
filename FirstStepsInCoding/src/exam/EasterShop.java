package exam;

import java.util.Scanner;

public class EasterShop {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int countEggs = Integer.parseInt(scanner.nextLine());
        int total =0;
        String input = scanner.nextLine();
        while (!input.equals("Close")){
            String buyOrFill = input;
            int eggs = Integer.parseInt(scanner.nextLine());
        if (buyOrFill.equals("Buy")){
            if (countEggs <= eggs) {
                break;
            }
                countEggs -= eggs;
                total += eggs;
        }else if(buyOrFill.equals("Fill")){
            countEggs += eggs;
        }
            input = scanner.nextLine();
        }

        if(input.equals("Close")){
            System.out.println("Store is closed!");
            System.out.printf("%d eggs sold.%n", total);
        }else{
            System.out.println("Not enough eggs in store!");
            System.out.printf("You can buy only %d.%n",countEggs);
        }
    }
}
