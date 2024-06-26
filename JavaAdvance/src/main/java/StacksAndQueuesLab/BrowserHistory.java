package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String currentUrl = "";
//        String currentUrl = null;

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = stack.pop();
                }
            } else {
                if (currentUrl != "") {
                    stack.push(currentUrl);
                }
                currentUrl = input;
            }
            System.out.println(currentUrl);


            input = scanner.nextLine();
        }

    }
}
