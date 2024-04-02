package GenericsExercises.Threeuple.Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] data = input.split(" ");
        String firstAndLast = data[0] + " " + data[1];
        String neighborhood = data[2];
        String city = data[3];

        Threeuple<String, String,String > first = new Threeuple<>(firstAndLast,neighborhood,city);

        input = scanner.nextLine();

        String[] data1 = input.split(" ");
        String name = data1[0];
        int litterOfBeers = Integer.parseInt(data1[1]);
        boolean drunkOrNot = false;
        if (data1[2].equals("drunk")){
            drunkOrNot = true;
        }else{
            drunkOrNot = false;
        }

        Threeuple<String, Integer,Boolean > second = new Threeuple<>(name, litterOfBeers,drunkOrNot);

        input = scanner.nextLine();

        String[] data2 = input.split(" ");
        String namePerson = data2[0];
        double balance = Double.parseDouble(data2[1]);
        String bankName = data2[2];

        Threeuple<String,Double,String > third = new Threeuple(namePerson,balance,bankName);

        System.out.println(first);

        System.out.println(second);

        System.out.println(third);


    }
}

