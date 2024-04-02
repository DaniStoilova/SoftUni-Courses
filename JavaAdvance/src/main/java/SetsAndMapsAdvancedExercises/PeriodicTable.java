package SetsAndMapsAdvancedExercises;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");


            for (String element : input) {
                set.add(element);



            }
//            Collections.addAll(set,input);

        }

//        for (String element : set) {
//            System.out.print(element + " ");
//        }

        set.stream().forEach(e->System.out.print(e + " "));

//        String result = String.join(" ",set);
//        System.out.print(result);





    }
}
