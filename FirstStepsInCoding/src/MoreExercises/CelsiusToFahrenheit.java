package MoreExercises;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double temperatureC = Double.parseDouble(scanner.nextLine());

        double temperatureF = temperatureC * 9/5 + 32;

        System.out.printf("%.2f", temperatureF);



    }
}
