
package Exam1;

import java.util.Scanner;

public class Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = 1;
        int start = 5364;
        int counter = 0;

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            if (input.equals("Yes")) {
                days++;
            }
            counter = Integer.parseInt(scanner.nextLine());
            start += counter;

            if (start >= 8848 || days == 5) {
                break;
            }
            input = scanner.nextLine();
        }
        if (start >= 8848) {
            System.out.printf("Goal reached for %d days!", days);
        } else {
            System.out.println("Failed!");
            System.out.printf("%d", start);
        }
    }
}




















