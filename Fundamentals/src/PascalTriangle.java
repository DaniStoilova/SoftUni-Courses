import java.io.FilterOutputStream;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [] numbers = new int[n];

        
        for (int rows = 0; rows < n; rows++) {
            numbers[rows] = 1;
            for (int columns = 0; columns <= rows; columns++) {
                System.out.print(numbers[rows] + " ");
            numbers[rows] = numbers[rows] * (rows - columns)/(columns + 1);

            }
            System.out.println();
        }

    }
}
