package WhileLoop;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int countCake = width * length;
        while (countCake >= 0){
            String input = scanner.nextLine();
            if(input.equals("STOP")){
                break;
            }


        int pieces = Integer.parseInt(input);
        countCake -= pieces;

        }

        if(countCake > 0){
            System.out.printf("%d pieces are left.", countCake);
        }else{
            System.out.printf("No more cake left! You need %d pieces more.",Math.abs(countCake));
        }
    }
}
