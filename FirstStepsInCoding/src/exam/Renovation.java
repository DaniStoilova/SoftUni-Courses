package exam;

import java.util.Scanner;

public class Renovation {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int high = Integer.parseInt(scanner.nextLine());
        int wide = Integer.parseInt(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        int total = high * wide * 4;
        int wall = total - (total*percent/100);



        while (wall > 0){
            String input = scanner.nextLine();
            if (input.equals("Tired!")){
                break;
            }
            int paint = Integer.parseInt(input);
            wall -= paint;

        }
        if (wall > 0){
            System.out.printf("%d quadratic m left.", wall);
        }else{
            System.out.printf("All walls are painted and you have %d l paint left!", Math.abs(wall));
        }
    }
}
