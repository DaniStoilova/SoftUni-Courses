package WhileLoop;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wantedBook = scanner.nextLine();

        int countBooks = 0;
        boolean wasFound = false;
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("No More Books")) {
            String currentBooks = inputLine;

            if (currentBooks.equals(wantedBook)){
            wasFound = true;
            break;
        }
        countBooks++;
        inputLine = scanner.nextLine();
        }

        if (wasFound == true) {
            System.out.printf("You checked %d books and found it.", countBooks);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", countBooks);
        }
    }
}


