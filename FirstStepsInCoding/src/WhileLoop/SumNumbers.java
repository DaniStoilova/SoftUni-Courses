package WhileLoop;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        //докато тяхната сума стане по-голяма или равна на първоначалното число
        int sum = 0;
        while (sum < number) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            sum += currentNumber;

        }

        System.out.println(sum);


    }


}
