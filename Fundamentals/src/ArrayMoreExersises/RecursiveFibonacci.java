package ArrayMoreExersises;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] fib = new int[n + 1];

        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {


            fib[i] = fib[i - 1] + fib[i - 2];


        }

        System.out.println(fib[n - 1]);


    }
}
