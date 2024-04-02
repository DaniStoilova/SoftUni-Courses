package StakckAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        StringBuilder builder = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String[] commandLine = scanner.nextLine().split(" ");
            String command = commandLine[0];

            switch (command) {
                case "1":
                    String text = commandLine[1];
                    builder.append(text);
                    stack.push(builder.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(commandLine[1]);
                    builder.delete(builder.length() - count,builder.length());
                    stack.push(builder.toString());

                    break;
                case "3":
                    int index = Integer.parseInt(commandLine[1]);
                    char symbol = builder.toString().charAt(index - 1);

                    System.out.println(symbol);


                    break;
                case "4":
                    stack.pop();
                    builder = new StringBuilder();
                    builder.append(stack.peek());

                    break;
            }

        }


    }
}
