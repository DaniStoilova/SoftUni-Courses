package exam;

import java.util.Scanner;

public class PaintingEggs {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String eggs = scanner.nextLine();
        String colorEggs = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        double price = 0;
        if (eggs.equals("Large")){
            if(colorEggs.equals("Red")){
                price = 16;
            }else if(colorEggs.equals("Green")){
                price = 12;
            }else if(colorEggs.equals("Yellow")){
                price = 9;
            }

        }else if(eggs.equals("Medium")){
            if(colorEggs.equals("Red")){
                price = 13;
            }else if(colorEggs.equals("Green")){
                price = 9;
            }else if(colorEggs.equals("Yellow")){
                price = 7;
            }

        }else if(eggs.equals("Small")){
            if(colorEggs.equals("Red")){
                price = 9;
            }else if(colorEggs.equals("Green")){
                price = 8;
            }else if(colorEggs.equals("Yellow")){
                price = 5;
            }

        }

        double total = count * price;
        double cost = total * 0.65;

        System.out.printf("%.2f leva.", cost);


    }
}
