package exam;

import java.util.Scanner;

public class Sum06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        boolean numberReached = false;
        int count = 0;
        for (int a = 1; a < 9; a++) {
            for (int b = 9; b > a; b--) {
                for (int c = 0; c < 9; c++) {
                    for (int d = 9; d > c; d--) {

                        int numSum = a + b + c + d;
                        int numMult = a * b * c * d;

                        if (numSum == numMult && n % 10 == 5) {
                            count++;
                            System.out.printf("%d%d%d%d%n", a, b, c, d);

                            numberReached = true;

                            break;
                        } else if (numMult / numSum == 3 && n % 3 == 0) {
                            count++;
                            System.out.printf("%d%d%d%d%n", d, c, b, a);
                            numberReached = true;
                            break;
                        }

                    if (numberReached) {
                        break;
                    }
                }
                if (numberReached) {
                    break;
                }
            }
            if (numberReached) {
                break;
            }
        }
        if (numberReached) {
            break;
        }
    }
        if (count == 0) {
            System.out.println("Nothing found");
        }
    }
}


