package ArrayMoreExersises;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        int[] number = new int[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            char[] symbol = name.toCharArray();
            int sum = 0;
            int num = 0;
            for (int j = 0; j < symbol.length; j++) {
                char element = symbol[j];
                if (element == 'a' || element == 'e' || element == 'i' || element == 'o' || element == 'u' ||
                        element == 'A' || element == 'E' || element == 'I' || element == 'O' || element == 'U') {
                    num = element * symbol.length;

                } else {
                    num = element / symbol.length;
                }

                sum += num;

                number[i] = sum;

            }


        }
        Arrays.sort(number);

        for (int element : number) {
            System.out.println(element);
        }


    }
}
