package DataTypesAndVariablesMoreExersises;

import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String name = "";
        for (int i = 1; i <= n; i++) {
            char symbol = scanner.nextLine().charAt(0);
            symbol += key;
            name += symbol;
        }

        System.out.println(name);

    }
}
