package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

            for (int j = 1; j <= 10; j++){
                int result = n * j;
                System.out.printf("%d X %d = %d%n", n,j,result);
            }
        }
    }
