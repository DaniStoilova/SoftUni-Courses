package exam;

import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int i=start; i <= end; i++){
            int currentNumber = i;

            for (int j=4; j >= 1; j--){
                int digit = currentNumber % 10;

                if (digit % 2 == 0){

                }
                currentNumber =currentNumber/10;

            }

            System.out.print(i + " ");
        }








    }
}
