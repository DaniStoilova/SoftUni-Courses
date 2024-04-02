package DefiningClassesLab.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarInfo impala = new CarInfo();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            impala.setBrand(input[0]);
            impala.setModel(input[1]);
            impala.setHorsePower(Integer.parseInt(input[2]));

            System.out.println(impala.toString());
        }


    }
}
