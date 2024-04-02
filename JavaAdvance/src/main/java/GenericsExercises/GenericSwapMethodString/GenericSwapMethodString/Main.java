package GenericsExercises.GenericSwapMethodString.GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box box = new Box();


        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            box.add(element);
        }

        String[] indexes = scanner.nextLine().split(" ");
        int first = Integer.parseInt(indexes[0]);
        int second = Integer.parseInt(indexes[1]);

        box.swap(first, second);


        System.out.println(box);


    }
}
