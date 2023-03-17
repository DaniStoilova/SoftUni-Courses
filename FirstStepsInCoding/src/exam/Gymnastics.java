package exam;

import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String equipment = scanner.nextLine();


        double t = 0.000;
        double i = 0.000;
        if (country.equals("Russia")) {
            if (equipment.equals("ribbon")) {
                t = 9.100;
                i = 9.400;

            } else if (equipment.equals("hoop")) {
                t = 9.300;
                i = 9.800;
            } else if (equipment.equals("rope")) {
                t = 9.600;
                i = 9.000;
            }

        } else if (country.equals("Bulgaria")) {
            if (equipment.equals("ribbon")) {
                t = 9.600;
                i = 9.400;
            } else if (equipment.equals("hoop")) {
                t = 9.550;
                i = 9.750;
            } else if (equipment.equals("rope")) {
                t = 9.500;
                i = 9.400;
            }

        } else if (country.equals("Italy")) {
            if (equipment.equals("ribbon")) {
                t = 9.200;
                i = 9.500;
            } else if (equipment.equals("hoop")) {
                t = 9.450;
                i = 9.350;
            } else if (equipment.equals("rope")) {
                t = 9.700;
                i = 9.150;
            }

        }
        double total = t + i;
        double percent = (20-total)/20 * 100;
        System.out.printf("The team of %s get %.3f on %s.%n",country, total,equipment);
        System.out.printf("%.2f%%",percent);
    }

}
