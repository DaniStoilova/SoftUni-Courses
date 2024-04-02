package GenericsExercises.GenericCountMethodDouble.GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            double element = Double.parseDouble(scanner.nextLine());
            box.add(element);
        }


        double elementToCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(box.count(elementToCompare));


    }
}
