package DefiningClassesLab.Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split(" ");

//            CarInfo carInfo = input.length == 1
//                    ? new CarInfo(input[0])
//                    : new CarInfo(input[0], input[1], Integer.parseInt(input[2]));


            if (input.length == 1) {
                System.out.println(new CarInfo(input[0]));
            } else {
             System.out.println(new CarInfo(input[0], input[1], Integer.parseInt(input[2])));
            }


        }


    }
}
