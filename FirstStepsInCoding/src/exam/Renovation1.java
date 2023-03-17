package exam;

import java.util.Scanner;

public class Renovation1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int high = Integer.parseInt(scanner.nextLine());
        int wide = Integer.parseInt(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        int total = high * wide * 4;
        int wall = total - (total*percent/100);


        String input = scanner.nextLine();
        while (!input.equals("Tired!")){
            int paint = Integer.parseInt(input);
            wall -= paint;
            if (wall <= 0){
                break;
            }

            input = scanner.nextLine();

        }
        if (wall >= 0){
            System.out.printf("%d quadratic m left.", wall);
        }else{
            System.out.printf("All walls are painted and you have %d l paint left!", Math.abs(wall));
        }
    }
}


