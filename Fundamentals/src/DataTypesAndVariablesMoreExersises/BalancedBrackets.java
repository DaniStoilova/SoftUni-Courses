package DataTypesAndVariablesMoreExersises;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int openBrackets = 0;
        int closeBrackets = 0;
        for (int i = 1; i <= n; i++) {
            String elements = scanner.nextLine();

            if (elements.equals("(")) {
                openBrackets++;
            } else if (elements.equals(")")) {
                closeBrackets++;
                if (openBrackets - closeBrackets != 0) {
                    System.out.println("UNBALANCED");
                    return;
                }
            }

        }
        if ( openBrackets == closeBrackets){
            System.out.println("BALANCED");
        }else{
            System.out.println("UNBALANCED");
        }
    }
}
