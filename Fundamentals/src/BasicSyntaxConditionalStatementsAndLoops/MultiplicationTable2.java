package BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        if (m > 10) {
            System.out.printf("%d X %d = %d%n", n, m, n * m);
        } else {
            for (int j = m; j <= 10; j++) {
                int result = n * j;
                System.out.printf("%d X %d = %d%n", n, j, result);

            }
        }
    }
}

