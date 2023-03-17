package MoreExercises;

import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();

        switch (time) {
            case "sunny":
                System.out.println("It's warm outside!");
                break;
            default:
            case "cloudy":
            case "snowy":
                System.out.println("It's cold outside!");
                break;

        }


    }
}
