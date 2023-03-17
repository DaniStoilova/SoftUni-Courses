package MoreExersice;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] line = input.split("@");
            String[] line1 = line[1].split("\\|");
            String[] command = input.split("#");
            String[] command1 = command[1].split("\\*");

            String name = line1[0];
            String age = command1[0];

            System.out.printf("%s is %s years old.%n", name, age);
        }


    }
}
