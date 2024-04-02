package GenericsExercises.Tuple.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] data = input.split(" ");
        String firstAndLast = data[0] + " " + data[1];
        String city = data[2];

        Tuple<String, String> tuple = new Tuple<>(firstAndLast, city);

        input = scanner.nextLine();

        String[] data1 = input.split(" ");
        String name = data1[0];
        int litterOfBeers = Integer.parseInt(data1[1]);

        Tuple<String, Integer> tupleSecond = new Tuple<>(name, litterOfBeers);

        input = scanner.nextLine();

        String[] data2 = input.split(" ");
        Integer first = Integer.parseInt(data2[0]);
        double second = Double.parseDouble(data2[1]);

        Tuple<Integer,Double> tupleThird = new Tuple<>(first,second);

        System.out.println(tuple);

        System.out.println(tupleSecond);

        System.out.println(tupleThird);


    }
}
