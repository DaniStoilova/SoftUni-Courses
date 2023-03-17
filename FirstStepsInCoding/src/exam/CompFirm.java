package exam;

import java.util.Scanner;

public class CompFirm {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int r = 0;
        int sumR = 0;
        int s = 0;
        int count = 0;
        double sale = 0;
        double percent = 0;
        double total = 0;
        double average = 0;

        for (int i = 1; i <= n; i++) {
            int raiting = Integer.parseInt(scanner.nextLine());
            r = (raiting % 10);
            sumR += r;
            count++;
            s = (raiting / 10);

            if (r == 2) {
                sale = 0;
            } else if (r == 3) {
                sale = 0.5 * s;
            } else if (r == 4) {
                sale = 0.7 * s;
            } else if (r == 5) {
                sale = 0.85 * s;
            } else if (r == 6) {
                sale = 1.00 * s;
            }
            total += sale;
            average = sumR * 1.0 / count;
        }
            System.out.printf("%.2f%n", total);
            System.out.printf("%.2f", average);
        }
    }

